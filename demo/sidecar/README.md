# Sidecar Pattern

## Build Sidecar container

```
docker build -t git-poller .
```

## Creating sidecar via bind mounts

```

```

* [Bind Mounts](https://docs.docker.com/engine/admin/volumes/bind-mounts/)

## Creating sidecar via Voulumes

* [Volumes](https://docs.docker.com/engine/admin/volumes/volumes/)

```
docker run -d --mount source=html-data,target=/var/lib/data git-poller
docker run -d --mount source=html-data,target=/var/www/html -p 8080:80 centos/httpd
docker volume ls
```

## Start HTTP daemon with volume link

## Kubernetes Example

```yaml
apiVersion: v1
kind: Pod
metadata:
  name: web-app
spec:
  containers:
  - name: app
    image: docker.io/centos/httpd
    ports:
      - containerPort: 80
    volumeMounts:
    - mountPath: /var/www/html
      name: git
  - name: poll
    image: axeclbr/git
    volumeMounts:
    - mountPath: /var/lib/data
      name: git
    env:
      - name: GIT_REPO
        value: https://github.com/mdn/beginner-html-site-scripted
    command:
    - "sh"
    - "-c"
    - "git clone $(GIT_REPO) . && watch -n 600 git pull"
    workingDir: /var/lib/data
  volumes:
  - emptyDir: {}
    name: git
```
