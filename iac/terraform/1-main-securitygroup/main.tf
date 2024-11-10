provider "aws" {
	version = "~> 2.0"
	region = "us-east-1"
}

resource "aws_instance" "dev" {
	count = 3
	ami = "ami-053b0d53c279acc90"
	instance_type = "t2.micro"
	key_name = "key-pair-first"
	tags = {
		name = "dev${count.index}"
	}
	vpc_security_group_ids = ["${aws_security_group.allow_ssh.id}"]
}


#######

resource "aws_instance" "dev4" {
        ami = "ami-053b0d53c279acc90"
        instance_type = "t2.micro"
        key_name = "key-pair-first"
        tags = {
                name = "dev4"
        }
        vpc_security_group_ids = ["${aws_security_group.allow_ssh.id}"]
	depends_on = [aws_s3_bucket.dev4bucket]
}

resource "aws_instance" "dev5" {
        ami = "ami-053b0d53c279acc90"
        instance_type = "t2.micro"
        key_name = "key-pair-first"
        tags = {
                name = "dev5"
        }
        vpc_security_group_ids = ["${aws_security_group.allow_ssh.id}"]
}


#######


resource "aws_s3_bucket" "dev4bucket"{
	bucket = "rdbucket-dev4"
	# acl = "private" -> default
	tags = {
		name = "rdbucket-dev4"
	}
}
