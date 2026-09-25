import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class MERCBusTicketGroup6
{
   public static void main(String []args) throws IOException
   {
      Scanner sc = new Scanner(System.in);
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int passengerCount = 0;
      int menuChoice;
      int bulkBaggageAmount = 0;
      char insuranceCheck = 'a';
      char bulkBaggage;
      double insuranceFinale = 0.0;
      double vatCharge = 0.0;
      double totalCharges;
      int seniorCitizenVATExemptAndDiscounts = 0;
      int childrenDiscount = 0;
      final double CHILDREN_DISCOUNT = 0.05;
      double finalChildrenDiscount = 0.0;
      final double SENIOR_CITIZEN_DISCOUNT = 0.20;
      double seniorCitizenDiscount = 0.0;
      final double GROUP_DISCOUNT = 0.05;
      
      int ctr = 0;
      while(ctr < 1)
      {
         System.out.println(" _____________________________________");
         System.out.println("|     MERC Bus Ticket Reservation     |");
         System.out.println("|                                     |");
         System.out.println("|        [1] = Reserve a seat         |");
         System.out.println("|             [2] = Exit              |");
         System.out.println("|                                     |");
         System.out.println("|_____________________________________|");
         System.out.println("");
         menuChoice = sc.nextInt();
         
         if(menuChoice == 1)
         {
            System.out.print("Enter the number of Passengers: ");
            passengerCount = sc.nextInt(); 
         
            String[] passengerName = new String[passengerCount];
            System.out.print("Enter the names of the Passengers: ");
            
            int x = 0;
            for(x = 0;x < passengerName.length;x++)
            {
               passengerName[x] = br.readLine();
            }
            
            int[] passengerAge = new int[passengerCount]; 
            System.out.print("Enter the age of the Passengers: "); 
            
            x=0;
            while (x < passengerAge.length)
            {
               passengerAge[x] = sc.nextInt();
                  if(passengerAge[x] >= 0 && passengerAge[x] <= 118)
                     {
                        if(passengerAge[x] >= 60)
                        {
                           seniorCitizenVATExemptAndDiscounts++;
                        }
                        else if(passengerAge[x] <= 10)
                           childrenDiscount++;
                           
                        x++;
                     }
                  else
                     System.out.println("Invalid Age. Please Try Again.");
            }
            
            if(Arrays.stream(passengerAge).allMatch(y -> y < 18)) 
            {
               System.out.println("You need at least one adult in order to continue with the booking process. Please try again once this condition is fulfilled.");
               break;
            }

            System.out.println(" ________________________________________________________________________________");
            System.out.println("|                 Which type of bus would you like to book for?                  |");
            System.out.println("|                  [A] = Class A        (Seats Available: 27)                    |");
            System.out.println("|                  [B] = Class B        (Seats Available: 35)                    |");
            System.out.println("|                  [C] = Class C        (Seats Available: 35)                    |");
            System.out.println("|                  [D] = Ordinary Class (Seats Available: 56)                    |");
            System.out.println("|________________________________________________________________________________|");
            System.out.println("");
            
            int ctr2 = 0;
            while(ctr2 < 1)
            {
               char busClass = sc.next().charAt(0);
               if(busClass == 'A' || busClass == 'a' || busClass == 'B' || busClass == 'b' || busClass == 'C' || busClass == 'c' || busClass == 'D' || busClass == 'd')
               {
                  x=0;
                  while(x < 1)
                  {
                     if(busClass == 'A' || busClass == 'a')
                     {
                        if(passengerCount > 27)
                        {
                           System.out.println("Sorry. The Passenger Count Exceeds the Bus Limit. Please Try Again");
                           break;
                        }
                        else
                           x++;
                     }
                     else if(busClass == 'B' || busClass == 'b')
                     {
                        if(passengerCount > 35)
                        {
                           System.out.println("Sorry. The Passenger Count Exceeds the Bus Limit. Please Try Again");
                           break;
                        }
                        else
                           x++;
                     }
                     else if(busClass == 'C' || busClass == 'c')
                     {
                        if(passengerCount > 35)
                        {
                           System.out.println("Sorry. The Passenger Count Exceeds the Bus Limit. Please Try Again");
                           break;
                        }
                        else
                           x++;
                     }
                     else if(busClass == 'D' || busClass == 'd')
                     {
                        if(passengerCount > 56)
                        {
                           System.out.println("Sorry. The Passenger Count Exceeds the Bus Limit. Please Try Again");
                           break;
                        }
                        else
                           x++;
                     }
                  }
                  
                  System.out.print("Do the passengers have bulk baggage(Y/N)? ");
                  int ctr1 = 0;
                  while(ctr1 < 1)
                  {
                     bulkBaggage = sc.next().charAt(0);
                     if(bulkBaggage == 'Y' || bulkBaggage == 'y')
                     {   
                        ctr2 = 0;
                        while(ctr2 == 0)
                        {
                        System.out.print("How many among the passengers booked/reserved have bulk baggage? ");
                        bulkBaggageAmount = sc.nextInt();
                           if (bulkBaggageAmount > passengerCount)
                           {
                              System.out.println("Invalid Amount. Please Try Again.");
                           }
                           else
                              ctr2++;
                        }
                        ctr1++;
                     }
                     else if(bulkBaggage == 'N' || bulkBaggage == 'n')
                        break;
                     else
                        System.out.println("Invalid Input. Please try again.");
                  }
                     
                  int ctr3 = 0;  
                  while(ctr3 < 1)
                  {
                     System.out.print("Would you like to avail insurance(Y/N)? ");
                     insuranceCheck = sc.next().charAt(0);
                        if(insuranceCheck == 'Y' || insuranceCheck == 'y' || insuranceCheck == 'N' || insuranceCheck == 'n')
                           ctr3++;
                        else
                           System.out.println("Invalid Input. Please Try Again.");
                  }     
                  
                  System.out.println(" __________________________________________________");
                  System.out.println("|  Would you like a one-way trip or a round trip?  |");
                  System.out.println("|                                                  |");
                  System.out.println("|               [A] = One-way Trip                 |");
                  System.out.println("|                [B] = Round Trip                  |");
                  System.out.println("|                                                  |");
                  System.out.println("|__________________________________________________|");
                  char tripSettings = sc.next().charAt(0);
                     
                  int ctr4 = 0;
                  while(ctr4 < 1)
                  {
                     if(tripSettings == 'A' || tripSettings == 'a' || tripSettings == 'B' || tripSettings == 'b')
                     {
                        System.out.println(" __________________________________");
                        System.out.println("|  Please select your destination  |");
                        System.out.println("|         [1] = Ilocos             |");
                        System.out.println("|         [2] = Pampanga           |");
                        System.out.println("|         [3] = Zambales           |");
                        System.out.println("|         [4] = Baguio             |");
                        System.out.println("|         [5] = Apari              |");
                        System.out.println("|         [6] = La Union           |");
                        System.out.println("|         [7] = Nueva Ecija        |");
                        System.out.println("|         [8] = Tuguegarao         |");
                        System.out.println("|         [9] = Laoag              |");
                        System.out.println("|         [0] = Pangasinan         |");
                        System.out.println("|__________________________________|");
                        int destination = sc.nextInt();
                           
                        int ctr5 = 0;
                        while(ctr5 < 1)
                        {
                           if(destination >= 0 && destination <= 9)
                           {
                              /*PRICE DITO*/
                              double bulkBaggagePrice = bulkBaggagePriceMethod(busClass, bulkBaggageAmount);
                                    
                              double priceDestination = destinationPrice(busClass, destination);
                              if(tripSettings == 'B' || tripSettings == 'b')
                                 priceDestination = priceDestination * 2;
                              
                              if(insuranceCheck == 'Y' || insuranceCheck == 'y')
                                 insuranceFinale = insuranceMethod(busClass, passengerCount);
                              
                              priceDestination = priceDestination * passengerCount;
                              vatCharge = priceDestination * 0.12;

                              if(seniorCitizenVATExemptAndDiscounts >= 1)
                              {
                                 vatCharge = vatCharge * (passengerCount - seniorCitizenVATExemptAndDiscounts);
                                 seniorCitizenDiscount = SENIOR_CITIZEN_DISCOUNT * seniorCitizenVATExemptAndDiscounts;
                              }
                                 
                              else
                                 vatCharge = vatCharge * passengerCount;
                               
                              if(childrenDiscount >= 1)
                                 finalChildrenDiscount = CHILDREN_DISCOUNT * childrenDiscount;    
                                 
                              totalCharges = priceDestination + bulkBaggagePrice + insuranceFinale + vatCharge;
                              
                              System.out.println("BOOKING DETAILS:");
                              System.out.println("________________________");
                              System.out.println("Number of Passengers: " + passengerCount);
                              System.out.println("Passenger Names: ");
                              System.out.println("");
                              
                              for(x = 0;x < passengerName.length;x++)
                              {
                                 System.out.println(passengerName[x]);
                              }
                              
                              System.out.println("");
                              System.out.println("Passenger Ages: ");
                              System.out.println("");
                              for(x = 0; x < passengerAge.length;x++)
                              {
                                 System.out.println(passengerAge[x]);
                              }
                              System.out.println("________________________");
                              System.out.println("Starting Point: Manila");
                              
                              String destinationA = destinationMethod(destination);
                              System.out.println("Destination: " + destinationA);
                              
                              if(tripSettings == 'A' || tripSettings == 'a')
                                 System.out.println("ONE-WAY TRIP");
                              else
                                 System.out.println("ROUND TRIP");
                                 
                              System.out.println("");
                              System.out.println("PRICE DETAILS: ");
                              System.out.println("________________________");
                              System.out.println("Trip Price: " + priceDestination);
                              System.out.println("Bulk Baggage: " + bulkBaggagePrice);
                              System.out.println("Insurance: " + insuranceFinale);
                              System.out.println("________________________");
                              System.out.println("VAT Charge: " + ((priceDestination * 0.12) * passengerCount));
                              System.out.println("VAT Exempt: " + "-" + ((priceDestination * 0.12) * seniorCitizenVATExemptAndDiscounts) );
                              System.out.println("Total VAT: " + vatCharge);
                              System.out.println("________________________");
                              System.out.println("Total Charges: " + totalCharges);
                              System.out.println("");
                              
                              double totalDiscounts = 0.0;
                              if(passengerCount >= 5)
                                 totalDiscounts = finalChildrenDiscount + seniorCitizenDiscount + GROUP_DISCOUNT;
                              else
                                 totalDiscounts = finalChildrenDiscount + seniorCitizenDiscount;
                              
                              System.out.println("DISCOUNTS: ");
                              System.out.println("________________________");   
                              System.out.println("Children's Discount: " + (CHILDREN_DISCOUNT * 100) + "% x " + childrenDiscount + " = " + ((CHILDREN_DISCOUNT * 100) * childrenDiscount));
                              System.out.println("Senior Citizen Discount: " + (SENIOR_CITIZEN_DISCOUNT * 100) + "% x " + seniorCitizenVATExemptAndDiscounts + " = " + ((SENIOR_CITIZEN_DISCOUNT*100) * seniorCitizenVATExemptAndDiscounts));
                              if(passengerCount > 4)
                                 System.out.println("Group Discount: " + (GROUP_DISCOUNT * 100));
                              System.out.println("________________________");
                              System.out.println("Total Discounts: " + (totalDiscounts * 100));
                              System.out.println("________________________");
                              System.out.println("FINAL CHARGES: " + (totalCharges - (totalCharges * totalDiscounts)));
                                    
                              ctr5++;
                           }
                           else
                              System.out.println("Invalid Input. Please Try Again.");
                        }     
                           ctr4++;
                        }
                        else
                           System.out.println("Invalid Input. Please Try Again.");
                  }
                  ctr2++;     
               }
                  else
                     System.out.println("Invalid Input. Please try again.");
            }
            ctr++;
         }
         
         else if (menuChoice == 2)
         {
            System.out.println("Thank you for using the program.");
            break;
         }
         
         else
         {
            System.out.println("Invalid input. Please try a valid input.");
         } 
      }
   }
   
   public static String destinationMethod(int l)
   {
      String destination[] = {"Pangasinan", "Ilocos", "Pampanga", "Zambales", "Baguio", "Apari", "La Union", "Nueva Ecija", "Tuguegarao", "Laoag"};
      return destination[l];
   }
   
   public static double bulkBaggagePriceMethod(char q, int p)
   {
      double bulkBaggageExtraPrice=0.0;
      final double[] BAGGAGE_PRICE_PER_CLASS = {300, 250, 200, 150};
         if(q == 'A' || q == 'a')
            bulkBaggageExtraPrice = BAGGAGE_PRICE_PER_CLASS[0] * p;
         else if(q == 'B' || q == 'b')
            bulkBaggageExtraPrice = BAGGAGE_PRICE_PER_CLASS[1] * p;
         else if(q == 'C' || q == 'C')
            bulkBaggageExtraPrice = BAGGAGE_PRICE_PER_CLASS[2] * p;
         else
            bulkBaggageExtraPrice = BAGGAGE_PRICE_PER_CLASS[3] * p;
      
      return bulkBaggageExtraPrice;
   }
   
   public static double insuranceMethod(char c, int t)
   {
      double insuranceFinal;
      if(c == 'A' || c == 'a')
         insuranceFinal = 450 * t;
      else if(c == 'B' || c == 'b')
         insuranceFinal = 350 * t;
      else if (c == 'C' || c == 'c')
         insuranceFinal = 250 * t;
      else
         insuranceFinal = 175 * t;
   
      return insuranceFinal;
   }
   
   //hinahanap dito is ung class ng bus and ung destination
   public static double destinationPrice(char a, int b)
   {
      double classABusPrice[] = {800.0, 750.0, 500.0, 415.0, 585.0, 1300.0, 850.0, 900.0, 850.0, 900.0};
      double classBBusPrice[] = {700.0, 450.0, 400.0, 390.0, 485.0, 975.0, 750.0, 875.0, 750.0, 875.0};
      double classCBusPrice[] = {675.0, 425.0, 375.0, 350.0, 400.0, 870.0, 650.0, 735.0, 690.0, 735.0};
      double ordinaryBusPrice[] = {550.0, 375.0, 275.0, 335.0, 350.0, 900.0, 540.0, 630.0, 520.0, 620.0};
      
      if(a == 'A' || a == 'a')
         return classABusPrice[b];
      
      else if(a == 'B' || a == 'b') 
         return classBBusPrice[b];
      
      else if(a == 'C' || a == 'c') 
         return classCBusPrice[b];
      
      else
         return ordinaryBusPrice[b];   
   }
   
}

/*
Known Issues:
- di alam kung iaapply pa ba ung vat charge sa luggage + insurance

Mga Kulang pa dito
- Amount to be paid at syaka change
- Confirming kung okay ba ung details ng receipt
*/
