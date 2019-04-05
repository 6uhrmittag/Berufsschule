#!/usr/bin/env bash



# allow password login
sed -i 's/ChallengeResponseAuthentication no/ChallengeResponseAuthentication yes/g' /etc/ssh/sshd_config
sed -i 's/PasswordAuthentification no/PasswordAuthentification yes/g' /etc/ssh/sshd_config
service ssh restart



#install requirements
#REQUIREMENTS="git"
REQUIREMENTS=""
if [[ ! -z $REQUIREMENTS ]]; then
    apt-get update
    apt-get install -y -q --no-install-recommends $REQUIREMENTS
fi


# remove banner
if [[ -f '/etc/update-motd.d/50-motd-news' ]]; then
    rm /etc/update-motd.d/50-motd-news
    rm /etc/update-motd.d/80-livepatch
    rm /etc/update-motd.d/51-cloudguest
    rm /etc/update-motd.d/80-esm
    rm /etc/update-motd.d/95-hwe-eol
    rm /etc/update-motd.d/91-release-upgrade
    rm /etc/update-motd.d/10-help-text
fi
