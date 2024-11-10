terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 3.27"
    }
  }
}

provider "aws" {
        region = "us-east-1"
}

#######

resource "aws_instance" "dev" {
    ami = var.ami["us-east-1"]
    instance_type = var.free.instance
    key_name = var.key_name
    vpc_security_group_ids = ["${aws_security_group.aws-terraform-security-group.id}"]		
    tags = {
        Name = "dev"
    }
}