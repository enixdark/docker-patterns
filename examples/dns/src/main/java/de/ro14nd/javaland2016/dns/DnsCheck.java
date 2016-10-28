package de.ro14nd.javaland2016.dns;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;

import com.spotify.dns.DnsSrvResolver;
import com.spotify.dns.DnsSrvResolvers;
import com.spotify.dns.LookupResult;

public class DnsCheck {

    public static void main(String[] args) throws NamingException, InterruptedException, IOException {
        String host = null;
        String mode = null;
        String dnsServer = null;
        String type = "A";
        String sleepS = System.getenv("K8S_SLEEP");
        int sleep = sleepS != null ? Integer.parseInt(sleepS) : 0;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-m")) {
                mode = args[++i];
            } else if (args[i].equals("-s")) {
                dnsServer = args[++i];
            } else if (args[i].equals("-t")) {
                type = args[++i].toUpperCase();
            } else {
                host = args[i];
            }
        }

        Thread.sleep(sleep * 1000);

        if (host == null) {
            throw new IllegalArgumentException("No hostname provided");
        }

        if ("spotify".equalsIgnoreCase(mode)) {
            lookupSpotify(host,dnsServer,type);
        } else {
            lookupJndi(host,dnsServer,type);
        }

    }

    private static void lookupSpotify(String host, String dnsServer, String type) throws IOException {
        DnsSrvResolver resolver = DnsSrvResolvers.newBuilder()
                                                 .cachingLookups(true)
                                                 .retainingDataOnFailures(true)
                                                 .dnsLookupTimeoutMillis(1000)
                                                 .build();

        List<LookupResult> nodes = resolver.resolve(host);

        if (!"SRV".equalsIgnoreCase(type)) {
            throw new IllegalArgumentException("Can only lookup records of type SRV (and not " + type +")");
        }
        printHeadline("spotify/dns-java",host, dnsServer, type);
        for (LookupResult node : nodes) {
            System.out.println(node.host() + ":" + node.port());
        }
    }

    public static void lookupJndi(String host, String dnsServer, String type) throws NamingException {
        Hashtable env = new Hashtable();
        env.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
        env.put("java.naming.provider.url", dnsServer != null ? "dns://" + dnsServer : "dns:");
        DirContext ctx = new InitialDirContext(env);
        Attributes attrs = ctx.getAttributes(host, new String[] { type });
        NamingEnumeration rEnum = attrs.getAll();

        printHeadline("JNDI DNS",host, dnsServer, type);
        while (rEnum.hasMore()) {
            Attribute attr = (Attribute) rEnum.next();
            System.out.println(attr.get());
        }
        rEnum.close();
    }

    private static void printHeadline(String what, String host, String dnsServer, String type) {
        System.out.println(what + " Lookup for " +
                           host + " with type " + type + (dnsServer != null ? " (dns server: " + dnsServer + ")" : "") + ": ");
    }

}
