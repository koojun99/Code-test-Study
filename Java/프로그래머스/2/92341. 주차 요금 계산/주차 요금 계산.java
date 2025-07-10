import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inMap = new HashMap<>();
        Map<String, Integer> total = new HashMap<>();
        
        for (String record: records) {
            String time = record.split(" ")[0];
            String car = record.split(" ")[1];
            String action = record.split(" ")[2];
            
            if(action.equals("IN")) {
                inMap.put(car, getMinutes(time));
            }
            
            if(action.equals("OUT")) {
                int inTime = inMap.remove(car);
                int totalTime = getMinutes(time) - inTime;
                total.put(car, total.getOrDefault(car, 0) + totalTime);
            }
        }
        
        for (String car : inMap.keySet()) {
            int inTime = inMap.get(car);
            int totalTime = getMinutes("23:59") - inTime;
            total.put(car, total.getOrDefault(car, 0) + totalTime);
        }
        
        List<String> cars = new ArrayList<>(total.keySet());
        Collections.sort(cars);
        
        int[] answer = new int[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            int time = total.get(cars.get(i));
            answer[i] = calculateFee(fees, time);
        }
        
        return answer;
    }
    
    private int getMinutes(String time) {
        String[] splits = time.split(":");
        return Integer.parseInt(splits[0])*60 + Integer.parseInt(splits[1]);
    }
    
    private int calculateFee(int[] fees, int time) {
        int baseTime = fees[0], baseFee = fees[1];
        int unitTime = fees[2], unitFee = fees[3];
        
        if (time <= baseTime) return baseFee;
        return baseFee + (int)Math.ceil((time - baseTime) / (double)unitTime) * unitFee;
    }
}