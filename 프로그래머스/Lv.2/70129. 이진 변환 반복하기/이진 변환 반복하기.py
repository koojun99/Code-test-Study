def solution(s):
    erased_zeros = 0
    count = 0
    
    while s != "1":
        length_before = len(s)
        s = s.replace("0", "") 
        length_after = len(s)
        erased_zeros += length_before - length_after 
        
        s_length = length_after
        binary = ""
        while s_length > 0:
            binary = str(s_length % 2) + binary
            s_length = s_length // 2
        s = binary
        count += 1
    
    return [count, erased_zeros]