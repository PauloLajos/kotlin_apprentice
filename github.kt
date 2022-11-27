pkg update
Ctrl-d
termux-change-repo
pkg install git openssh mc kotlin
termux-setup-storage

ssh-keygen -t ed25519 -C "your_email@example.com"
eval "$(ssh-agent -s)"
ssh-add ~/.ssh/id_ed25519
//Add the SSH key to your account on GitHub
cat ~/.ssh/id_ed25519.pub

git config --global user.name "Lajos Paulo"
git config --global user.email "paulolajos@mail.com"
git config --global credential.helper 'cache --timeout=3600'
git config --global --add safe.directory '*'

//gh aut login

git init -b main
git config remote.origin.url git@github.com:PauloLajos/kotlin_apprentice.git
git remote add origin https://github.com/PauloLajos/kotlin_apprentice.git
//git branch -M main
git pull --rebase origin main
//git pull origin main

git add .
git commit -m "My commit message"
//git pull --rebase origin main
git push origin main
