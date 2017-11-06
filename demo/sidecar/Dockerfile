FROM axeclbr/git

ENV GIT_REPO "-b sidecar-html-demo https://github.com/ro14nd-talks/docker-patterns"

WORKDIR /var/lib/data
ENTRYPOINT rm -rf .git * && git clone ${GIT_REPO} . && watch -n 10 git pull
