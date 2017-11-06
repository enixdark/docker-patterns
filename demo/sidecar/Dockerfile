FROM axeclbr/git

ENV GIT_REPO https://github.com/mdn/beginner-html-site-scripted

WORKDIR /var/lib/data
ENTRYPOINT rm -rf .git * && git clone ${GIT_REPO} . && watch -n 10 git pull
