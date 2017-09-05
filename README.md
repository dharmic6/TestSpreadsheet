

# TestSpreadsheet

sudo su root




49  docker ps
   50  docker kill 951313ed678a
   51  docker ps
   52  docker images
   53  docker pull dharmic6/testdocker:6
   54  docker images
   55  nohup bash -c "docker run -p 80:8080 cad6b4936055 > /tmp/spreadsheet.log 2>&1 &"
   56  tail -f /tmp/spreadsheet.log




 sudo yum update -y
 sudo yum install -y docker
sudo service docker start
sudo usermod -a -G docker ec2-user
  docker ps
docker pull dharmic6/testdocker:10
nohup bash -c "docker run -p 80:8080 cad6b4936055 > /tmp/spreadsheet.log 2>&1 &"

