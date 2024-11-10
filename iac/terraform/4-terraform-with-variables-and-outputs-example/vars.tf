variable "ami" {
    type = map(string)
    default = {
        "us-east-1" = "ami-053b0d53c279acc90"
        "us-east-2" = "ami-0430580de6244e02e"
    }
}

variable "cdir_remote_access" {
    type = list(string)
    default = ["179.109.45.79/32"]
}

variable "free" {
    type = map(string)
    default = {
        "instance" = "t2.micro"
    }
}

# type default = map(string)
variable "key_name" {
    default = "terraform-aws"
}