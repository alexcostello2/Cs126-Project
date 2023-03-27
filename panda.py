"""
Who: GT
Why: Practice turtle
What: Draw the Panda
Where: CS125 L2
When: Oct 18th

"""

from turtle import *
speed(0)
# Define function
def myCircle(rad, color):
    fillcolor(color) # Set the color 
    begin_fill()    # Ask to fill the shape with color
    circle(rad)     # draw the circle
    end_fill()      # Stop filling the shape/ Circle


# Start with the left ear
penup()
setpos(-40, 100)
pendown()
myCircle(15, 'black')

# Second ear
penup()
setpos(40, 100)
pendown()
myCircle(15, 'black')

# face
up() # penup()
setpos(0,40)
pd()  # pendown()
myCircle(40, 'white')

# Left bigger eye
up()
setpos(-20, 80)
pd()
myCircle(10, "black")

# Right bigger eye
up()
goto(20, 80)
pd()
myCircle(10,"black")

# Left white eye
up()
goto(-20, 80)
pd()
myCircle(5,"white")

# Right white eye
up()
goto(20, 80)
pd()
myCircle(5,"white")

# Nose
up()
goto(0, 55)
pd()
myCircle(5,"black")

# mouth
up()
goto(0,55)
pd()
right(90)
circle(5, 180)

up()
goto(0,55)
pd()
left(360)
circle(5, -180)


hideturtle()











