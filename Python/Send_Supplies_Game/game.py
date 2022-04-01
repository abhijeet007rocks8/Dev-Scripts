"""
<---Story---> 
Lieutenant John Fowl is admist a war torn area.His troops need supplies ASAP and 
there is no time to waste.He makes his way to different strategic places to receive the
supplies. By sheer will and determination, he makes his way to the rendezvous point.
Just as he was taking a quick breath, a bzzz sound is heard and what appears is a plane 
flying towards him. John's relived face soon turns into horror as he realizes discovers the
package dropped by plane, is a BOMB!. He then checks back his intel, and finds out that their cover
is blown.Enemy planes are disguised as friendly with not so friendly intention. John's team
is in dire need of supplies and a new plan will take 3 months minimum
Gear up as you are the last hope of lieutenant


TASK:- Help Lt.John Fowl to receive the packages from the allies' plane and beware
		of the enemy plane  and DON'T DIE

This simple game is made by pygame, a game library written in python language
Play through and feel free to fork it and add some addition of your own

Godspeed Reader!
"""






#importing necessary libraries
import pygame
import random



pygame.init()


#constants
SCREEN_WIDTH = 1080
SCREEN_HEIGHT = 625
FPS = 30
mediNum = 4

#setting up FPS
FramePerSec = pygame.time.Clock()

display = pygame.display.set_mode((SCREEN_WIDTH,SCREEN_HEIGHT))
display.fill((255,255,255))
pygame.display.set_caption("Send Supplies")
background_image = pygame.image.load("assets/PNG/bg1.png")


# image list for soldier
images_set = [
	pygame.image.load("assets/soldier-sprites/running1.png"),
	pygame.image.load("assets/soldier-sprites/running1.png"),
	pygame.image.load("assets/soldier-sprites/running1.png"),
	pygame.image.load("assets/soldier-sprites/running2.png"),
	pygame.image.load("assets/soldier-sprites/running2.png"),
	pygame.image.load("assets/soldier-sprites/running2.png"),
	pygame.image.load("assets/soldier-sprites/running3.png"),
	pygame.image.load("assets/soldier-sprites/running3.png"),
	pygame.image.load("assets/soldier-sprites/running3.png"),
	pygame.image.load("assets/soldier-sprites/running4.png"),
	pygame.image.load("assets/soldier-sprites/running4.png"),
	pygame.image.load("assets/soldier-sprites/running4.png"),
	pygame.image.load("assets/soldier-sprites/running5.png"),
	pygame.image.load("assets/soldier-sprites/running5.png"),
	pygame.image.load("assets/soldier-sprites/running5.png"),
	pygame.image.load("assets/soldier-sprites/running6.png"),
	pygame.image.load("assets/soldier-sprites/running6.png"),
	pygame.image.load("assets/soldier-sprites/running6.png")
	]


#background sound
def background_score():
	pygame.mixer.music.load("assets/bgmusic.wav")
	pygame.mixer.music.play(-1)

background_score()	


#classes for game sprites
class Soldier(pygame.sprite.Sprite):
	def __init__(self):
		super().__init__()
		self.image = pygame.image.load("assets/soldier-sprites/standing.png")
		self.width = self.image.get_width()
		self.height = self.image.get_height()
		self.rect = self.image.get_rect()
		self.rect.x,self.rect.y = (10,SCREEN_HEIGHT-(self.height+85))
		self.speed = 4
		self.index = 0 #for sprite animation
		self.lives = 3

	def move(self):
		self.image = pygame.image.load("assets/soldier-sprites/standing.png")

		pressed_keys = pygame.key.get_pressed()

		if pressed_keys[pygame.K_LEFT]:
			#check if character is not going off screen
			if self.rect.x>=0:
				self.rect.x += -self.speed
			if self.index >= len(images_set):
				self.index = 0
			self.image = pygame.transform.flip(images_set[self.index], True, False)
			self.index+=1

		if pressed_keys[pygame.K_RIGHT]:
			#check if character is not going off screen
			if self.rect.x<=SCREEN_WIDTH - self.width:
				self.rect.x += self.speed
			if self.index >= len(images_set):
				self.index = 0
			self.image = images_set[self.index]
			self.index+=1



class Airplane(pygame.sprite.Sprite):

	def __init__(self, speedX=round(random.uniform(2, 4), 2),ismediPlane=False):
		super().__init__()
		self.image = pygame.image.load(f"assets/planes/pl{random.randint(1,4)}.png")
		self.width = self.image.get_width()
		self.height = self.image.get_height()
		self.rect = self.image.get_rect()
		self.has_dropped = False
		self.preffered_dropping_point = random.randint(0,SCREEN_WIDTH-self.width)
		self.speedX = speedX
		self.mediPlane = random.randint(1,5)

	def update(self):
		self.rect.x +=self.speedX



class Drops(pygame.sprite.Sprite):
	def __init__(self,x,y,isFood,medkit=False):
		super().__init__()
		self.isFood = isFood
		self.medKit = medkit
		if self.isFood:
			self.image = pygame.image.load("assets/drops/food.png")
		elif self.medKit:
			self.image = pygame.image.load("assets/drops/medkit.png")
		else:
			self.image = pygame.image.load("assets/drops/boom.png")
		self.width = self.image.get_width()
		self.height = self.image.get_height()
		self.rect = self.image.get_rect()
		self.rect.x,self.rect.y = (x,y+self.height)
		self.projectile_speed = round(random.uniform(2,3.5), 2)


	def update(self):
		self.rect.y += self.projectile_speed


#initialising classes to variables
p1 = Soldier()
a1 = Airplane()
medPlane = Airplane(speedX=4.4, ismediPlane=True)

airplane_sprites = pygame.sprite.Group()
all_sprites = pygame.sprite.Group()
drop_sprites = pygame.sprite.Group()


all_sprites.add(p1)
all_sprites.add(a1)
airplane_sprites.add(a1)


def score():
	"""
	function to keep track of scores and update it
	"""
	global points
	if p1.lives > 0:
		for drop in drop_hit_list:
			if drop.medKit:
				p1.lives+=1
			elif drop.isFood:
				points += 1
			else:
				p1.lives-=1

				

def text_on_screen(textcontent,position,size,color,isBold=False,isItalic=False):
	''' custom function to draw text on screen with different styles'''
	text =  pygame.font.SysFont('comicsans',size,bold=isBold,italic=isItalic).render(textcontent, True, color)
	display.blit(text,position)


def draw():
	'''the main draw function which puts stuff on the screen'''
	display.blit(background_image,(0,0))
	if p1.lives > 0:
		for entity in all_sprites:
			try:
				display.blit(entity.surf, entity.rect)
			except AttributeError:
				display.blit(entity.image,entity.rect)
	
	score_bg = pygame.image.load("assets/PNG/score-bg.png")
	display.blit(score_bg,(0,SCREEN_HEIGHT-85))

	#update points and soldier lives
	text_on_screen(f"{points}", (240, 547), 50, (166,166,166))
	text_on_screen(f"X{p1.lives}", (924, 552), 35, (166, 166, 166),True)

	
def check_pos():
	'''function to check if plane is out of view and init a new plane while removing the later'''
	for plane in airplane_sprites:
		if plane.rect.x > SCREEN_WIDTH:
			airplane_sprites.remove(plane)
			all_sprites.remove(plane)
			b1 = Airplane()
			all_sprites.add(b1)
			airplane_sprites.add(b1)


def gameOver():
	'''the game over function to print when the player loses'''
	global end_time
	if p1.lives == 0:
		p1.image = pygame.image.load("assets/soldier-sprites/dying.png")
		display.blit(p1.image,(p1.rect.x,p1.rect.y+50))
		text_on_screen("the game is over",(10,SCREEN_HEIGHT/2),100,(0,0,0),True)



#some main-loop variables
points = 0
run = True


#main loop
while run:
	
	for event in pygame.event.get():
		if event.type == pygame.QUIT: run =False


	display.fill((255,255,255))
	check_pos()

	if p1.lives > 0:
		p1.move()

		for plane in airplane_sprites:
			plane.update()
			
				
			if not plane.has_dropped:
				#drop the packages ranging from food,medkit and bomb
				if int(plane.rect.x) >= plane.preffered_dropping_point:
					if plane.mediPlane == mediNum:
						print("MEDKIT DROPPED.... ")
						medkit = Drops(plane.rect.x,plane.height,False,True)
						all_sprites.add(medkit)
						drop_sprites.add(medkit)
						plane.has_dropped = True
					else:
						isFood = random.randint(0,1)

						if isFood:
							d1 = Drops(plane.rect.x,0,isFood)
						else:
							d1 = Drops(plane.rect.x,0,isFood)
						all_sprites.add(d1)
						drop_sprites.add(d1)
						plane.has_dropped = True

		#remove drops if they go off screen and are not received by player
		for drop in drop_sprites:
			drop.update()
			if drop.rect.y >= SCREEN_HEIGHT-85:
				drop_sprites.remove(drop)
				all_sprites.remove(drop)
		
		
		drop_hit_list = pygame.sprite.spritecollide(p1, drop_sprites, True)

	#call the functions
	draw()
	score()
	gameOver()

	#update the screen and set the FPS
	pygame.display.update()
	FramePerSec.tick(FPS)

#quit the game
pygame.quit()

