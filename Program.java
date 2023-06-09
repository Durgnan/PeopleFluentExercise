import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Program {
    public static String calculateTotalCost(String[] items)
    {
        int totalApples = 0;
        int totalOranges = 0;
        double appleCost = 0.6;
        double orangeCost = 0.25;
        double totalCost = 0;

        for(int i = 0; i < items.length; i++)
        {
            String item = items[i];
            totalCost += item.equals("Apple") ? appleCost : item.equals("Orange") ? orangeCost : 0;
        }

        return "£"+totalCost;
    }

    public static String calculateTotalCostWithOffers(String[] items)
    {
        int totalApples = 0;
        int totalOranges = 0;
        double appleCost = 0.6;
        double orangeCost = 0.25;
        double totalCost = 0;
        HashMap<String,Integer> mapper = new HashMap<String,Integer>();
        mapper.put("Apple", 0);
        mapper.put("Orange", 0);
        for(String item: items)
        {
            switch(item)
            {
                case "Apple": mapper.put("Apple",mapper.get("Apple")+1); break; 
                case "Orange": mapper.put("Orange",mapper.get("Orange")+1); break; 
                default: break; 
            }
        }

        totalApples = mapper.get("Apple");
        totalOranges = mapper.get("Orange");

        totalCost = (((totalApples - totalApples%2)/2) * appleCost)+((totalApples%2)*appleCost);
        totalCost += (totalOranges - totalOranges%3)/3 * (orangeCost*2)+((totalOranges%3)*orangeCost) ;

        
        // Step 2 Initial Approach
        // for(int i = 0; i < items.length; i++)
        // {
        //     String item = items[i];
        //     totalCost += item.equals("Apple") ? appleCost : item.equals("Orange") ? orangeCost : 0;
        // }

        return "£"+ Math.round(totalCost*100.0)/100.0;
    }



    public static void main(String[] args) {
        ArrayList<String> items = new ArrayList<String>();
        String item;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Items.\nPress 0 to Stop");
        while(true) {
            item = sc.nextLine();     
            if(item.equals("0"))
                break;       
            items.add(item);
        }

        String[] itemArray = Arrays.copyOf(items.toArray(),items.size(), String[].class);
        // Step 1 Result 
        System.out.println("Total Cost: "+ calculateTotalCost(itemArray));
        // Step 2 Result 
        System.out.println("Total Cost with offers: "+ calculateTotalCostWithOffers(itemArray));
        sc.close();

    }
}