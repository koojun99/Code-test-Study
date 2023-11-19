def solution(wallpaper):
    drag = []
    lux = []
    luy = []
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[i])):
            if wallpaper[i][j] == '#':
                lux.append(i)
                luy.append(j)
                
    drag.append(min(lux))
    drag.append(min(luy))
    drag.append(max(lux)+1)
    drag.append(max(luy)+1)
        
    return drag