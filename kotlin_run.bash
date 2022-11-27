if test -z "$1"
then
  echo "Argument is empty"
else
  echo
  echo "Start compile $1..."
  echo
  kotlinc $1.kt -include-runtime -d $1.jar && java -jar
  echo
fi