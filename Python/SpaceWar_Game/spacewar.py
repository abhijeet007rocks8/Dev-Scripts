import pygame
import os
pygame.font.init()
pygame.mixer.init()
pygame.init()

WIN_WIDTH,WIN_HEIGTH = 900,500
WINDOW = pygame.display.set_mode((WIN_WIDTH,WIN_HEIGTH))#window dimension
pygame.display.set_caption("SpaceWar")#window title
WINDOW_COLOR=(255,255,255) #window bg color
FPS=60 # feames per sec
VELOCITY = 3.4

GUARDIAN_MAX_BULLETS = 3
ENEMY_MAX_BULLETS = 3

GUARDIAN_BULLETS_COLOR = (54, 246, 243)
ENEMY_BULLETS_COLOR = (228, 245, 34)
BULLETS_VELOCITY =  VELOCITY ** 2

GUARDIAN_HIT = pygame.USEREVENT + 1
ENEMY_HIT = pygame.USEREVENT + 2


IMAGE_WIDTH, IMAGE_HEIGHT= 65,55
GUARDIAN_SHIP = pygame.image.load(os.path.join("Assets", "guardian_ship.png"))
GUARDIAN_SHIP_RESHAPED = pygame.transform.scale(GUARDIAN_SHIP, (IMAGE_WIDTH,IMAGE_HEIGHT))
ENEMY_SHIP = pygame.image.load(os.path.join("Assets", "evil_ship4.png"))
ENEMY_SHIP_RESHAPED = pygame.transform.rotate( pygame.transform.scale(ENEMY_SHIP, (IMAGE_WIDTH +25,IMAGE_HEIGHT +25)) ,90)
SPACE_BG = pygame.image.load(os.path.join("Assets", "space.jpg"))
BORDER = pygame.Rect(WIN_WIDTH//2 ,0, 2, WIN_HEIGTH)


FONT = pygame.font.SysFont("comicsans",40)
WINNER_FONT = pygame.font.SysFont("comicsans", 100)

BULLET_HIT_SOUND =  pygame.mixer.Sound(".\Assets\Gun+Silencer.mp3  ")
BULLET_FIRE_SOUND= pygame.mixer.Sound(os.path.join("Assets", "Grenade+1.mp3"))

def guardian_key_Handler(keys_pressed, guardian):
    if  keys_pressed[pygame.K_UP]   and guardian.y >= 7  :  # moving UP
        guardian.y -= VELOCITY

    if  keys_pressed[pygame.K_DOWN]  and guardian.y <=440:  # moving DOWN
        guardian.y += VELOCITY

    if keys_pressed[pygame.K_LEFT]  and guardian.x>=3:  # moving Left
        guardian.x -= VELOCITY

    if keys_pressed[pygame.K_RIGHT] and guardian.x <= (WIN_WIDTH/2)-70 :  # moving DOWN
        guardian.x += VELOCITY

def enemy_key_Handler(keys_pressed, enemy):
    if  keys_pressed[pygame.K_w]   and enemy.y >= 7  :  # moving UP
        enemy.y -= VELOCITY

    if keys_pressed[pygame.K_s] and enemy.y <= 440:  # moving DOWN
        enemy.y += VELOCITY

    if  keys_pressed[pygame.K_a] and enemy.x >= (WIN_WIDTH/2):  # moving Left
        enemy.x -= VELOCITY

    if  keys_pressed[pygame.K_d] and enemy.x <= 830:  # moving DOWN
        enemy.x += VELOCITY
    #print(enemy.x,enemy.y)


def draw_Winner(winner):
    winner_text = WINNER_FONT.render(winner,1,WINDOW_COLOR)
    WINDOW.blit(winner_text , (WIN_WIDTH //2  - winner_text.get_width() /2, WIN_HEIGTH//2 - winner_text.get_height() /2))
    pygame.display.update()
    pygame.time.delay(2000)





def draw_window(enemy, guardian,guardian_bullets, enemy_bullets ,guardian_health, enemy_health   ):
    WINDOW.fill(WINDOW_COLOR)
    WINDOW.blit(SPACE_BG,(0,0) )
    WINDOW.blit(GUARDIAN_SHIP_RESHAPED, (guardian.x,guardian.y) )
    WINDOW.blit(ENEMY_SHIP_RESHAPED, (enemy.x, enemy.y) )
    pygame.draw.rect(WINDOW, (255, 0, 0 ) ,BORDER)

    G_health_Text = FONT.render("Health: "+str( guardian_health) ,1, WINDOW_COLOR )
    E_health_Text = FONT.render("Health "+str( enemy_health) ,1, WINDOW_COLOR )

    WINDOW.blit(E_health_Text, (WIN_WIDTH - E_health_Text.get_width()-10 , 10 ))
    WINDOW.blit(G_health_Text, (10 , 10 ))


    for bullet in guardian_bullets:
        pygame.draw.rect(WINDOW, GUARDIAN_BULLETS_COLOR, bullet)

    for bullet in enemy_bullets:
        pygame.draw.rect(WINDOW, ENEMY_BULLETS_COLOR, bullet )

    pygame.display.update()


def bullet_Handler(guardian_Bullets, enemy_Bullets, guardian, enemy):
    for bullet in guardian_Bullets:
        bullet.x += BULLETS_VELOCITY

        if enemy.colliderect(bullet):
            pygame.event.post(pygame.event.Event(ENEMY_HIT))
            guardian_Bullets.remove(bullet)
        elif bullet.x>WIN_WIDTH:
            guardian_Bullets.remove(bullet)

    for bullet in enemy_Bullets:
        bullet.x -= BULLETS_VELOCITY

        if guardian.colliderect(bullet):
            pygame.event.post(pygame.event.Event(GUARDIAN_HIT))
            enemy_Bullets.remove(bullet)
        elif bullet.x<0:
            enemy_Bullets.remove(bullet)






def main():
    enemy = pygame.Rect(790,300, IMAGE_WIDTH, IMAGE_HEIGHT)
    guardian = pygame.Rect(30, 300, IMAGE_WIDTH, IMAGE_HEIGHT, )
    run_game = True
    frame_clock = pygame.time.Clock()

    guardian_Bullets = []
    enemy_Bullets = []
    Enemy_Health = 10
    Guardian_Health = 10


    while run_game:
        frame_clock.tick(FPS)#setting Frame rate

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                run_game = False
                pygame.quit()

            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_RCTRL  and len(guardian_Bullets) < GUARDIAN_MAX_BULLETS:
                    bullet = pygame.Rect( guardian.x + guardian.width ,guardian.y + guardian.height//2 - 2 , 5 , 10  )
                    guardian_Bullets.append(bullet)
                    BULLET_FIRE_SOUND.play()




                if event.key == pygame.K_SPACE  and len(enemy_Bullets) < ENEMY_MAX_BULLETS:
                    bullet = pygame.Rect(enemy.x + enemy.width - 25 , enemy.y + enemy.height // 2 +14, 5, 10)
                    enemy_Bullets.append(bullet)
                    BULLET_FIRE_SOUND.play()



            if event.type  == GUARDIAN_HIT:
                Guardian_Health -= 1
                BULLET_HIT_SOUND.play()

            if event.type  == ENEMY_HIT:
                Enemy_Health -= 1
                BULLET_HIT_SOUND.play()
        winner = " "
        if Guardian_Health < 0:
            winner = " Aliens Wins"
        if Enemy_Health < 0:
            winner = "Guardian Wins"

        if winner != " ":
            draw_Winner(winner)
            break


        keys_pressed = pygame.key.get_pressed()
        guardian_key_Handler(keys_pressed,guardian)
        enemy_key_Handler(keys_pressed, enemy)

        bullet_Handler(guardian_Bullets,enemy_Bullets,guardian,enemy)

        draw_window(enemy,guardian ,guardian_Bullets ,enemy_Bullets,Guardian_Health ,Enemy_Health )

    for i in range(10,-1,-1):
        surface = pygame.display.get_surface()
        surface.fill(pygame.Color("black"))
        restart_text = WINNER_FONT.render(f"Game Restart in {i}", True, WINDOW_COLOR)
        WINDOW.blit(restart_text, (
        WIN_WIDTH // 2 - restart_text.get_width() / 2, WIN_HEIGTH  // 2 - restart_text.get_height() / 2))
        pygame.display.update()
        pygame.time.delay(1000)





    main()






if __name__ == "__main__":
    main()

