def solution(bandage, health, attacks):
    time = 1
    current_health = health
    bandage_duration = 0
    for attack in attacks:
        while time < attack[0]:
            if current_health < health:
                current_health += bandage[1]
                bandage_duration += 1
            if bandage_duration == bandage[0]:
                current_health += bandage[2]
                bandage_duration = 0
            current_health = min(current_health, health)
            time += 1
        current_health -= attack[1]
        bandage_duration = 0
        if current_health <= 0:
            return -1
        time += 1
    return current_health