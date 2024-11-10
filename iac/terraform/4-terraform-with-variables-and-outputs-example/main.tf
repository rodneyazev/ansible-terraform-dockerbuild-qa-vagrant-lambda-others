terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 2.0"
    }
  }
}

provider "aws" {
	region = "us-east-1"
}

provider "aws" {
	alias = "us-east-2"
	region = "us-east-2"
}


resource "aws_instance" "dev" {
	count = 4
	ami = "ami-053b0d53c279acc90"
	instance_type = var.free.instance
	key_name = var.key_name
	tags = {
		Name = "dev${count.index}"
	}
	vpc_security_group_ids = ["${aws_security_group.allow_ssh.id}"]
}


# =============================================================

resource "aws_instance" "dev4" {
        ami = "ami-053b0d53c279acc90"
        instance_type = var.free.instance
        key_name = var.key_name
        tags = { 
                Name = "dev4"
        }
        vpc_security_group_ids = ["${aws_security_group.allow_ssh.id}"]
	depends_on = [aws_s3_bucket.dev4bucket]
}

resource "aws_instance" "dev5" {
        ami = var.ami["us-east-1"]
        instance_type = var.free.instance
        key_name = var.key_name
        tags = {
                Name = "dev5"
        }
        vpc_security_group_ids = ["${aws_security_group.allow_ssh.id}"]
}


# =============================================================


resource "aws_s3_bucket" "dev4bucket"{
	bucket = "rdbucket-dev4"
	# acl = "private" -> default
	tags = {
		Name = "rdbucket-dev4"
	}
}



# =============================================================

# Servidor de Banco de Dados em outra região, vai ser necessário outro security group

resource "aws_instance" "dev6" {
		provider = aws.us-east-2
        ami = var.ami["us-east-2"]
        instance_type = var.free.instance
        key_name = var.key_name
        tags = {
                Name = "dev6"
        }
        vpc_security_group_ids = ["${aws_security_group.allow_ssh-us-east-2.id}"]
	depends_on = [aws_dynamodb_table.dynamodb-homologation]
}


resource "aws_dynamodb_table" "dynamodb-homologation"{
	provider = aws.us-east-2
	name = "MyDatabase"
	billing_mode = "PAY_PER_REQUEST"
	hash_key = "UserId"
	range_key = "Title"

	attribute {
		name = "UserId"
		type = "S"
	}

	attribute {
		name = "Title"
		type = "S"
	}
}

# =============================================================