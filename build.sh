#!/bin/bash

reset

export folderDevelopment="Project"
export folderRelease="Release"

# Get into the development directory
cd $folderDevelopment

# Remove any existing .class files from the bin directory
rm -rf ./bin

# Create the bin directory if it doesn't exist
mkdir -p ./bin

# Copy the assets directory to the bin directory
if [ -d ./assets ]; then
    cp -r ./assets ./bin
fi

# Compile the Java source files and place the .class files in the bin directory
javac -d ./bin/ ./src/*.java

# Create the Project.jar file with the specified manifest file and the contents of the bin directory
jar cfm ./Project.jar ./Manifest.txt -C bin .

# Remove any .class files from the bin directory
rm -rf ./bin

# Get out of the development directory
cd ..

# Move the Project.jar file to the release directory
rm -rf ./$folderRelease
mkdir -p ./$folderRelease
mv ./$folderDevelopment/Project.jar ./$folderRelease/Project.jar

# Create the 'run.sh' file
cat > run.sh << EOF
#!/bin/bash
java -jar Project.jar
EOF

# Create the 'run.ps1' file
cat > run.ps1 << EOF
java -jar Project.jar
EOF

# Fem l'arxiu executable
chmod +x run.sh
mv run.sh ./$folderRelease/run.sh
mv run.ps1 ./$folderRelease/run.ps1

# Run the Project.jar file
cd ./$folderRelease
./run.sh
cd ..