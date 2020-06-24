package com.example.coronaapp;

import java.util.LinkedList;
import java.util.Queue;

public class Global {
    // Leader
    public static int lost;
    public static int cat_offset;
    public static int cat_index;
    public static long counter = 0;
    public static long update_counter = 0;
    public static double current_active;
    public static double continuous_active_adder;
    public static double continuous_recovery_adder;
    public static double continuous_death_adder;
    public static double infection_percent;
    public static double multiplier;
    public static int dec_tak;
    static Queue<Double> red, ded;

    // Hidden Parameters
    /*
        1   Recovery rate
        2   Death rate (RR + DR = 1)
        3   Infection rate
     */
    public static double[] hidden_parameters = new double[3];

    // Parameters
    /*
        1   Active cases
        2   Deaths
        3   Recovered
        4   Total Cases
        5   Time
        6   Power
     */
    public static double[] parameters = new double[6];

    // Decisions
    public static int[] dec_active = new int[40];
    public static String[] decisions = {
            // Cost 1
            "Tackling Fake News",
            "Make Quarantine Centers",
            "Sanitizing Public Places",
            "Ask Celebs to spread Awareness",
            "Set Caller Tune to spread Awareness",
            "Provide Subsidized Internet Services",
            "Encouraging Doctors and health Workers",
            "Scan persons coming from other Countries",
            "Punish unnecessary Wanderers and Impose Fines",
            "Ask Streaming Platforms to provide free Subscription",

            // Cost 2
            "Halt Trains",
            "Close Markets",
            "Discontinue Buses",
            "Ban Domestic Flights",
            "Ban International Flights",
            "Preparation at Local Level",
            "Start Research for Vaccine",
            "Discontinue Cabs and Taxis",
            "Close Malls and Cinema Halls",
            "Close Factories and Companies",

            // Cost 3
            "Ask for Donation",
            "Close Schools and Colleges",
            "Call Army to Control Situation",
            "Indigenous Test Kits Production",
            "Ensure Safety to Homeless people",
            "Bring back NRIs from other Countries",
            "Speedup Production of Health Products",
            "Cooperate with other Countries and WHO",
            "Train Doctors of other Dept. for COVID",
            "Convert of Schools, Colleges to Hospitals",

            // Cost 4
            "Put Prisoners on Quarantine",
            "Distribute Free Masks",
            "Declare Bonus for Doctors",
            "Schedule Essential Services",
            "Impose Curfew and Lock-down",
            "Decide Prices to control Inflation",
            "Provide free Vans to supply Essentials",
            "Provide free Food to daily wage Workers",
            "Re-build whole budget to Focus on Disease",
            "Re-call retired Doctors and health Workers",
    };

    public static String[] descriptions = {
            "It will decrease the infection rate as unnecessary protests due to rumours will not happen",
            "It will decrease the infection rate as the infected will be in isolation, preventing the spread",
            "It will decrease the infection rate as the virus waiting for the carrier will be destroyed",
            "All the people follow some celebs. So, they will obey their advice to stay at home and break the chain, thus reducing the infection rate",
            "It will make the people aware about the virus and the precautions, thus decreasing the infection rate",
            "The people will be bored at home and may come out. This step will avoid it thus reducing the infection rate",
            "They are the front-line warriors in this hour of need. This step will increase the recovery rate",
            "It will decrease the infection rate as the infected will be in isolation, preventing the spread",
            "This step will ensure the social distancing thus decreasing the infection rate",
            "The people not financially capable enough may come out. This step will avoid it thus reducing the infection rate",

            "This step will avoid the chances of community and area transfer of the virus .Thus the infection rate is reduced",
            "This step will ensure the social distancing thus decreasing the infection rate as markets lure .people to come out",
            "This step will avoid the chances of community and area transfer of the virus .Thus the infection rate is reduced",
            "This step will avoid the chances of community and area transfer of the virus .Thus the infection rate is reduced",
            "As the COVID is a pandemic thus doing so will avoid the incoming of this virus. Hence the infection rate is reduced",
            "Being an incurable disease, this step will provide immediate facilities and thus will improve the recovery rate",
            "One of the most important works – will greatly increase the recovery rate",
            "This step will avoid the chances of community transfer of the virus .Thus the infection rate is reduced",
            "This step will ensure the social distancing thus decreasing the infection rate as they lure people to come out",
            "It will decrease the infection rate as the infected will be in isolation, preventing the spread",

            "This will financially support the fight, increasing the recovery rate",
            "Students of different age are prone to diseases and may act as better carriers due to location factor. Thus this step will highly reduce the infection rate",
            "The army will ensure better enforcement of the restrictions. Thus decreases the infection rate",
            "It will reduce the dependency on other countries. More tests means early control thus reducing the infection rate",
            "They can act as the potential carriers and even divert the attention in this fight. Thus this step will decrease the infection rate",
            "This does not affect the rates but it may lead to public resent and due to agitations the fight may get diverted. Thus this step is also important",
            "This will support the fight as the medical products are a luxury at this hour. It increases the recovery rate and decreases the mortality rate",
            "We cannot fight without information about the virus. Thus it is important to have all the available information about the virus. It may help with the vaccine development thus increasing the recovery rate",
            "There may be a sudden increase in the number of COVID patients. Thus this step will ensure proper treatment, increasing the recovery rate",
            "There may be a sudden increase in the number of suspected people. Thus it will decrease the infection rate as they will be in isolation, preventing the spread",

            "This step will avoid the community spread thus decreasing the infection rate",
            "The masks have proved to be an effective measure of precaution against the virus. Thus this step will greatly reduce the infection rate",
            "This step will boost the morale of the doctors, inspiring them to work harder. Thus it will lead to better recovery rates of the patient",
            "The people may agitate without the supply of the essential basic needs, leading to chances of spread of the virus. Thus it will avoid any such possibilities",
            "These steps will ensure better enforcement of the restrictions. Thus decreases the infection rate",
            "The people may agitate due to high increase in the prices of the essential basic needs, leading to chances of spread of the virus. Thus it will avoid any such possibilities",
            "The people may agitate without the supply of the essential basic needs, leading to chances of spread of the virus. Thus it will avoid any such possibilities. Moreover vans will ensure social distancing",
            "The people may agitate as they being the daily wage workers and sole bread winners leading to chances of deaths due to starvation. Thus it will avoid any such possibilities",
            "This will financially support the fight as there will be more funds thus ensure completion of all requirements in this fight",
            "There may be a sudden increase in the number of COVID patients. Thus this step will ensure proper treatment, increasing the recovery rate",
    };

    public static double[][] weights = {
            { // HP 1
                0.4,
                    0, 0, 0, 0, 0, 0, 0.001, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0.002, 0, 0, 0,
                    0, 0, 0.003, 0, 0, 0, 0.003, 0.003, 0.003, 0,
                    0, 0, 0.004, 0, 0, 0, 0, 0, 0.004, 0.004
            },
            { // HP 2
                0.05,
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0
            },
            { // HP 3
                0.23,
                    -0.15, -0.35, -0.44, -0.1, -0.15, -0.1, -0.1, -0.3, -0.05, -0.09,
                    -0.37, -0.3, -0.3, -0.41, -0.4, -0.21, -0.2, -0.28, -0.20, -0.45,
                    -0.2, -0.34, -0.15, -0.32, -0.18, -0.2, -0.33, -0.23, -0.26, -0.32,
                    -0.1, -0.43, -0.23, -0.25, -0.47, -0.1, -0.38, -0.2, -0.13, -0.4,
            }
    };

    public static void update_parameters()
    {
        dec_tak = 0;
        for(int i=0;i<40;i++)
            dec_tak += dec_active[i];

        counter++;
        update_counter++;

        if(counter%20 == 0)
            parameters[5]++;

        if(counter%2 == 0)
            parameters[4]++;

        if(update_counter%20 == 0)
        {
            infection_percent = weights[2][0];
            for(int i=1;i<=40;i++){
                if(dec_active[i-1] == 1)
                    infection_percent += (weights[2][i]/10);
            }
            current_active = parameters[0];
            if(infection_percent <= 0 && dec_tak < 30 && parameters[0] > 20)
            {
                infection_percent = 0;
                weights[0][0] = 0.1;
                red.clear();
                ded.clear();
            }
            else{
                if(counter > 850)
                    weights[0][0] = 0.8;
                else
                    weights[0][0] = 0.4;
            }

            continuous_active_adder = (current_active * multiplier * infection_percent)/10;
            red.add(current_active * weights[0][0]);
            ded.add(current_active * weights[1][0]);

            if(update_counter >= 28)
            {
                if(!red.isEmpty ()) {
                    continuous_recovery_adder = red.peek()/10;
                    continuous_death_adder = ded.peek()/10;
                    red.remove();
                    ded.remove();
                }
            }
        }

        if(update_counter%2 == 0) {
            if (continuous_death_adder + continuous_recovery_adder > parameters[0] + continuous_active_adder && dec_tak < 30) {
                parameters[2] += parameters[0];
                parameters[0] = 0;
                red.clear();
                ded.clear();
                for(int i=0;i<14;i++){
                    red.add(2.0);
                    ded.add(2.0);
                }
            } else {
                parameters[2] += continuous_recovery_adder;
                parameters[1] += continuous_death_adder;
                parameters[0] += continuous_active_adder - continuous_recovery_adder - continuous_death_adder;
            }
            parameters[3] = (long) parameters[0] + (long) parameters[1] + (long) parameters[2];
        }
    }


    public static void initialize_parameters() {
        red = new LinkedList<>();
        ded = new LinkedList<>();
        red.clear();
        ded.clear();
        counter = 0;
        update_counter = 0;
        current_active = 0;
        continuous_active_adder = 0;
        continuous_recovery_adder = 0;
        continuous_death_adder = 0;
        multiplier = 7;
        weights[0][0] = 0.5;
        weights[2][0] = 0.2;
        parameters[0] = 5;
        parameters[1] = 0;
        parameters[2] = 0;
        parameters[3] = 5;
        parameters[4] = 0;
        parameters[5] = 1;
    }

    // People
    public static long score;

    // Level 1
    public static int q_index;
    public static int[] truth = {1, 0, 1, 1, 0, 0, 0, 1, 0, 0};
    public static String[] questions = {
            "Wearing Masks",
            "Going Out unnecessarily ",
            "Keeping Distance of at least 1 metre from everyone",
            "Using Hand Sanitizers and Washing hands again and again",
            "Discouraging others who are following precautionary measures",
            "Hiding Potential Patients",
            "Taking Medicines without Doctor's Prescription",
            "Helping Poor People and Animals",
            "Spreading News without Verifying it",
            "Attending Social Gatherings"
    };
    public static String[] yes = {
            "Hurrah! You just avoid direct contact from any infected person, but still don't shake hands",
            "You are safe along with your family, helping the government in this fight",
            "Yup, you should do that. The virus is very far from you",
            "You just reduced the chances of yourself getting affected from not only COVID but many more diseases",
            "You are acting like a CORONA warrior in this time of need",
            "You just think about the whole humanity, you will be awarded as you saved many lives",
            "It is because you know that the doctors know better about the medicines",
            "It is the service of humanity. You will be rewarded by god for good deeds",
            "You are definitely an aware citizen of the nation",
            "Very Good! You just (may be) broke the chain of the virus and saved many lives"
    };
    public static String[] no = {
            "You are exposing yourself to the deadly virus",
            "Doing so you are helping the virus, risking yourself and your family. You are a big FOOL",
            "You are making the way of the virus easy",
            "You will yourself be responsible as it is one of the main precautions",
            "You yourself being a fool are fooling others. I am calling the Police",
            "You are doing a crime equivalent to MURDER. NSA is for you only",
            "No, you should not do so. It can harm you. What are Doctors for??",
            "You are acting like a selfish people. Go and help some creature, MAINTAINING DISTANCE!!",
            "You are spreading false information and can be booked under law. The jail is ready for you",
            "You just tried to help the spread of the virus. Wait!! Police is on the way"
    };
}
