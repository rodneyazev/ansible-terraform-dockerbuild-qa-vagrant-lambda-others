# terraform refresh

output "dev" {
    value = { for i in aws_instance.dev : i.tags["Name"] => i.public_ip}
}

output "dev4" {
  value = "${aws_instance.dev4.public_ip}"
}

output "dev5" {
  value = "${aws_instance.dev5.public_ip}"
}

output "dev6" {
  value = "${aws_instance.dev6.public_ip}"
}


