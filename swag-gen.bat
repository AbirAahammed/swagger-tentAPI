"C:\Program Files\7-Zip\7z" a ../tentAPI-Old.zip .
java -jar D:\Swagger-gen\swagger-codegen-cli-2.4.9.jar generate -i api-swagger.yaml -l spring
echo Project updated with new api documentation
