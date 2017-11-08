# Sidecar Pattern

## Build Sidecar container

```
docker build -t git-poller .
```

## Creating sidecar via bind mounts

```
docker run -d -v $(pwd)/html:/var/lib/data git-poller
docker run -d -v $(pwd)/html:/var/www/html -p 8080:80 centos/httpd
```

* [Bind Mounts](https://docs.docker.com/engine/admin/volumes/bind-mounts/)

## Creating sidecar via Voulumes

* [Volumes](https://docs.docker.com/engine/admin/volumes/volumes/)

```
docker run -d --mount source=html-data,target=/var/lib/data git-poller
docker run -d --mount source=html-data,target=/var/www/html -p 8080:80 centos/httpd
docker volume ls
```

## Browser

* Goto http://localhost:8080
* Then goto https://github.com/ro14nd-talks/docker-patterns/tree/sidecar-html-demo
* Adapt [scripts/main.js](https://github.com/ro14nd-talks/docker-patterns/blob/sidecar-html-demo/scripts/main.js)
* Reload page

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
