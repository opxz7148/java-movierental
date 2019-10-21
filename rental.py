class Rental:
	"""
	A rental of a movie by customer.
	From Fowler's refactoring example.
  
	Rental should have fields and methods for the dates
	that the movie was rented and returned, from which the
	rental period is calculated.
	But for simplicity of the example only a daysRented
	field is shown.
	"""
	
	def __init__(self, movie, days_rented): 
		"""Initialize a new movie rental object for
		   a movie with known rental period (daysRented).
		"""
		self.movie = movie
		self.days_rented = days_rented

	def get_movie(self):
		return self.movie

	def get_days_rented(self):
		return self.days_rented
