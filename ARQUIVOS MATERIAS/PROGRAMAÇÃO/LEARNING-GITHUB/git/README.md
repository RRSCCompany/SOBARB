
COMMITS:

### -> É ONDE VEMOS AS OPERAÇÕES FEITAS NOS ARQUIVOS, C (CREATE), R (READ), U (UPDATE), D (DELETE)

HOW TO CLONE A REPOSITORY:

### git clone http_url_from_github_in_button_download_code

### Example: git clone https://github.com/RenanGAS/Test-REPO.git

FOR ENTERING IN THE REPOSITORY, SET THIS COMMAND:

### cd name_of_the_repository

### Example: cd Test_REPO

## -> THIS WAY, YOU ARE GETTING THE GIT:{MASTER} DOING THIS

SOME DIFFERENT COMMANDS:

### UNIX -> LS
### WINDOWS -> DIR

MEANINGS:

### TRACK -> caminho, trilha

FOR TRACK ALL THE CHANGES IN THE REPOSITORY, TYPE THIS:

### git add .

FOR TRACK A SPECIFY FILE, TYPE THIS:

### git add name_file.type_file

FOR DO THE CHANGES, AFTER TRACK THEM:

### git commit -m "Title: Saving the changes in README.md and creating index.html"
###            -m "Description: I'm doing this because it's necessary"

### As you can see, the first -m is for the title text, and the second for the description text

FOR SAVE THE CHANGES, AFTER DO THEM:

### git push origin main
### -> origin é o local do repositório
### -> main é o Branch

FOR CREATE A KEY FOR GET ACCESS MORE EASIER, YOU HAVE TO CREATE A SSH-KEYGEN:

### TYPE IN ADMIN CMD:
### ssh-keygen

### than choose a random name_file, example "mykey" (I'm using this)
### Leave a empty passphrase
### So copy/save the PRIVATE KEY (for your machine, "mykey"),  
### and the PUBLIC KEY (for github, "mykey.pub")

### For see those keys, go to the ADMIN Power Shell and type this:
### Get-ChildItem *mykey*
### This will show you your keys

FOR ADD YOUR MYKEY.PUB ON GITHUB, GO TO ADMIN CMD, AND DO THIS:

### type mykey.pub
### cinst pasteboard
### type mykey.pub | pbcopy

### Copy the large expression showed after "type mykey.pub" , go to the settings of your account 

### In GITBASH, do this:
### ssh-agent -s

### In ADMIN CMD, do this:
### start-ssh-agent

### *Those returns it's all in the txt file: GITHUB_SSH-KEYGEN_!IMPORTANT


FOR CREATE A NEW REPOSITORY, YOU HAVE TO CREATE A FOLDER OUT OF THE PASSED REPO, PUT A README.md ON IT, AND EXECUTE THIS COMMAND:

### git init

FOR SEE WHAT IS IN THERE:

### git status

FOR CREATE A TRACK TO THE FILE TO GITHUB:

### git add name_file.type_file

FOR SEND THE FILE TO GITHUB:

### git commit -m "Created README.md" -m "Now we have a README.md in Test-REPO2"

HOWEVER, WE CREATED THIS REPOSITORY IN OUR LOCAL MACHINE. FOR CREATE ON GITHUB TOO, WE HAVE TO GO IN THERE, AND CREATE A NEW EMPTY REPOSITORY WITH THE SAME NAME THAT WE PUT ON THE FOLDER

AFTER, WE HAVE TO COPY THE HTTP LINK, THAT REPRESENT THE TRACK FOR THE REPOSITORY ON GITHUB, AND DO THIS COMMAND:

### git remote add origin https://github.com/RenanGAS/Test-REPO2.git

FOR CHECK IT OUT:

### git remote -v

FOR SEND TO GITHUB:

### git push -u origin master

TOTAL SEQUENCE FOR SAVE A MODIFICATION:

### git add .

### or

### git add name_file.type_file    <- THE BEST OPTION

### git commit -m "Modifying README.md" -m "This was necessary"

### git push -u origin master

THE BRANCHES EXIST FOR DO TESTS ON THE CODE OF MAIN BRANCH, WITHOUT MODIFY HIM. IT ALLOWS US TO DO TESTS, AND IF THEY WORK, SAVE INTO THE MAIN BRANCH. IT LIKES A COPY ON NETBEANS. IS JUST FOR TESTS, FOR PEOPLE WHO WANT TO COLABORATE IN YOUR CODE.

FOR SHOW YOUR BRANCHES, TYPE THIS:

### git branch

FOR LEAVE THIS SCREEN, TYPE THIS:

### q

FOR NAVIGATE INTO THE BRANCHES:

-> FOR CREATE A BRANCH:

### git checkout -b name_branch/description

-> FOR CHANGE THE BRANCH:

### git checkout name_branch

### m

