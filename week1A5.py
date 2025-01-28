class Place:
    def print_me(self):
        print("Buy it.")

class Region(Place):
    def print_me(self):
        print("Box it.")

class State(Region):
    def print_me(self):
        print("Ship it.")

class Maryland(State):
    def print_me(self):
        print("Read it.")

def main():
    east = State()            # Region reference to a State object
    md = Maryland()           # State reference to a Maryland object
    obj = Place()             # Object reference to a Place object
    usa = Region()            # Place reference to a Region object

    md.print_me()             # Maryland’s `print_me()` -> "Read it."
    east.print_me()           # State’s `print_me()` -> "Ship it."
    obj.print_me()            # Place’s `print_me()` -> "Buy it."
    usa.print_me()            # Region’s `print_me()` -> "Box it."
    md.print_me()             # Maryland’s `print_me()` -> "Read it."
    east.print_me()           # State’s `print_me()` -> "Ship it."

if __name__ == "__main__":
    main()
