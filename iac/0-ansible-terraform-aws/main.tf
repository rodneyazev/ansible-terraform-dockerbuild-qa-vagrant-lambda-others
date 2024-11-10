terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 3.27"
    }
  }

  required_version = ">= 0.14.9"
}

provider "aws" {
  profile = "default"
  region  = "us-east-1"
}

resource "aws_instance" "app_server" {
  ami           = "ami-09d56f8956ab235b3"
  instance_type = "t2.micro"
  key_name = "IACVotc"
#  user_data = <<-EOF
#		 #!/bin/bash
#		 cd /home/ubuntu
#		 echo "<h1>Created with Terraform</h1>" > index.html
#		 nohup busybox httpd -f -p 8080 &
#		 EOF
  tags = {
    Name = "Terraform Ansible Python"
  }
}
