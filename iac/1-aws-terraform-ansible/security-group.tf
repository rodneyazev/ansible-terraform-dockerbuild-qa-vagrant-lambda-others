resource "aws_security_group" "aws-terraform-security-group" {
        name = "aws-terraform-security-group"
        description = "Allowed ports"

        // SSH
        ingress {
                from_port = 22
                to_port = 22
                protocol = "tcp"
                cidr_blocks = var.cdir_remote_access
        }

        // HTTP
        ingress {
                from_port   = 80
                to_port     = 80
                protocol    = "tcp"
                cidr_blocks = var.cdir_remote_access
        }

        // HTTP Proxy
        ingress {
                from_port   = 8080
                to_port     = 8080
                protocol    = "tcp"
                cidr_blocks = var.cdir_remote_access
        }

        // HTTPS
        ingress {
                from_port   = 443
                to_port     = 443
                protocol    = "tcp"
                cidr_blocks = var.cdir_remote_access
        }

        // HTTPS Proxy
        ingress {
                from_port   = 8443
                to_port     = 8443
                protocol    = "tcp"
                cidr_blocks = var.cdir_remote_access
        }

        tags = {
                Name = "aws-terraform-security-group"
        }
}

// Ingress - means Outbound traffic
// Ingress - Inbound traffic