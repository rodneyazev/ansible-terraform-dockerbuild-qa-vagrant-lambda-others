variable "ami" {
    type = map(string)
    default = {
        "us-east-1" = "ami-053b0d53c279acc90"
    }
}

variable "free" {
    type = map(string)
    default = {
        "instance" = "t2.micro"
    }
}

// type default = map(string)  - it is an ssh key
variable "key_name" {
    default = "aws-terraform-cli"
}

// User your personal IP
variable "cdir_remote_access" {
    type = list(string)
    default = ["189.36.252.53/32"]
}