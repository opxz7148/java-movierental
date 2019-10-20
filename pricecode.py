# Refactoring: Replace Switch with Polymorphism
#
# Movies have a price code.
# The movie rental price is determined by its price code and rental period (days)
# Therefore, the price code should be responsible for computing
# the rental price.
# 
# The movie frequent renter points is determined by its price code and rental period.
# So, similarly, the FRP should be computed by price code.
#
# An enum defines a type with a fixed set of values (members).
# Each of the enum members can have its own attributes and methods,
# just like objects of a class.
# This enum has methods price(days) and frp(days).
#
# Instead of using if self.name = 'normal": .. elif .. else ..
# to compute the price, we assign a function (as lambda) directly
# to each enum member.
#
from enum import Enum

class PriceCode(Enum):
    #Enum members, written as name = value
    new_release = {"price": lambda days: 3.0*days,
                "frp": lambda days: days}
    childrens = {"price": lambda days: 1.5+1.5*max(0,days-3),
                "frp": lambda days: 1}
    normal = {"price": lambda days: 2.0+1.5*max(0,days-2),
                "frp": lambda days: 1}

    def price(self, days):
        """Return the rental price for rental period of days"""
        f = self.value["price"]
        return f(days)

    def frp(self, days):
        """Return frequent rental points for rental period of days"""
        return self.value["frp"](days)

    def __str__(self):
        """String representation of this size"""
        return self.name

def test_price_rules():
    print("Test pricing rules")
    for code in PriceCode:
        for days in range(1,5):
            print(f"{code} movie {days} day price: {code.price(days):5}  FRP: {code.frp(days)}")
        #print(code, "1 day:",code.price(1)," 2 days:",code.price(2)," 4 days", code.price(4))

if __name__ == "__main__":
    test_price_rules()
