package models.user

class Admin(name: String,email: String,password: String): User(name = name, email = email,password=password) {
}