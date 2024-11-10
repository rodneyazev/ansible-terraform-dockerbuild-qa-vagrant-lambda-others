ubuntu = aws ec2 instance user

ansible-playbook ansible/playbook.yml -u ubuntu --private-key aws-terraform-cli -i ansible/hosts.yml
