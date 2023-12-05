import datetime
def solution(a, b):
    days = ["MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"]
    day_of_week = datetime.datetime(2016, a, b).weekday()
    return days[day_of_week]
