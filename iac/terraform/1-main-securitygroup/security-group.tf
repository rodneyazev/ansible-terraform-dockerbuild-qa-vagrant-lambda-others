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
