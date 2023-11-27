def solution(babbling):
    sounds = ["aya", "ye", "woo", "ma"]
    count = 0
    
    for word in babbling:
        i = 0
        valid = True
        last_sound = ""
        while i < len(word):
            found = False
            for sound in sounds:
                if word[i:].startswith(sound):
                    if sound == last_sound:
                        valid = False
                        break
                    last_sound = sound
                    i += len(sound)
                    found = True
                    break
                    
            if not found or not valid:
                valid = False
                break
        if valid:
            count += 1
                    
    return count