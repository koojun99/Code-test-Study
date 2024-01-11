def solution(k, room_number):
    answer = []
    next_room = {}
    
    for num in room_number:
        visit = num
        visit_list = [visit]
        
        while visit in next_room:
            visit = next_room[visit]
            visit_list.append(visit)
            
        answer.append(visit)
        
        for room in visit_list:
            next_room[room] = visit + 1
            
    return answer