git config --global user.name "Lajos Paulo"
git config --global user.email "paulolajos@mail.com"

git init
git remote add origin https://github.com/PauloLajos/kotlin_apprentice.git
git branch -M main
git pull --rebase origin main

git add .
git commit -m "My commit message"
git push origin main
