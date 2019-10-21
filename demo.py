from movie import Movie
from rental import Rental
from customer import Customer

def make_movies():
	movies = [
		Movie("The Irishman", Movie.NEW_RELEASE),
		Movie("CitizenFour", Movie.REGULAR),
		Movie("Frozen", Movie.CHILDRENS),
		Movie("El Camino", Movie.NEW_RELEASE),
		Movie("Particle Fever", Movie.REGULAR)
		]
	return movies

def create_customer_and_rental():
	customer = Customer("Edward Snowden")
	days = 1
	for movie in make_movies():
		customer.addRental(Rental(movie,days))
		days += 1
	return customer

def print_report(customer: Customer):
	print( customer.createStatement() )

if __name__ == '__main__':
	customer = create_customer_and_rental()
	print_report(customer)
