class Solution {
    public String validIPAddress(String IP) {
        String[] nums;
        boolean flag = true;
        
        if (IP.length() == 0 || IP.charAt(IP.length() - 1) == '.' || IP.charAt(IP.length() - 1) == ':') return "Neither";
        
        
        if (IP.contains(":")) {
            nums = IP.split(":");
            flag = false;
        }
        else {
            nums = IP.split("\\.");
        }
        
        if (flag) {
            if (nums.length != 4) return "Neither";
            for (int i = 0;i < 4;i++) {
                if (nums[i].length() > 3 || nums[i].length() == 0) {
                    return "Neither";
                }
                else if (nums[i].length() > 1){
                    if (nums[i].charAt(0) == '0') return "Neither";
                    
                    int num = 0;
                    
                    for (int j = 0;j < nums[i].length();j++) {
                        if (!Character.isDigit(nums[i].charAt(j))) return "Neither";
                        
                        num = num * 10 + nums[i].charAt(j) - '0';
                    }
                    
                    if (num > 255) return "Neither";
                }
            }
            
            return "IPv4";
        }
        else {
            if (nums.length != 8) return "Neither";
            
            for (int i = 0;i < 8;i++) {
                if (nums[i].length() > 4 || nums[i].length() == 0) {
                    return "Neither";
                }
                
                for (int j = 0;j < nums[i].length();j++) {
                    if (!(nums[i].charAt(j) >= 'a' && nums[i].charAt(j) <= 'f') && !(nums[i].charAt(j) >= 'A' && nums[i].charAt(j) <= 'F') && !Character.isDigit(nums[i].charAt(j))) return "Neither";
                }
            }
            
            return "IPv6";
        }
    }
}
