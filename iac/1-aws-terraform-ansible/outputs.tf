// terraform refresh
output "dev" {
  value = "${aws_instance.dev.public_ip}"
}
