resource "aws_security_group" "allow_ssh" {
        name = "allow_ssh"
        description = "Allow SSH inbound traffic"
        ingress {
                from_port = 22
                to_port = 22
                protocol = "tcp"
                cidr_blocks = ["179.109.45.79/32"]
        }
        tags = {
                name = "ssh"
        }
}


# For us-east-2 - Database is in that region
resource "aws_security_group" "allow_ssh-us-east-2" {
        provider = aws.us-east-2
        name = "allow_ssh"
        description = "Allow SSH inbound traffic"
        ingress {
                from_port = 22
                to_port = 22
                protocol = "tcp"
                cidr_blocks = ["179.109.45.79/32"]
        }
        tags = {
                name = "ssh"
        }
}