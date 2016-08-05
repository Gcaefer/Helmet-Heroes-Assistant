package HHAPackage;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainFrame {

	private JFrame frmHelmetHeroesAssistant;
	private JTextField curLevel;
	private JTextField goalLevel;
	private JTextField curExp;
	private JTextField result;
	private JTextField levelMin;
	private JTextField levelMax;
	private JTextField attack;
	private JTextField weapon1min;
	private JTextField weapon1max;
	private JTextField weapon2min;
	private JTextField weapon2max;
	private JTextField enemyDef;
	private JTextField percentCrit;
	private JTextField critMult;
	private JTextField minResult;
	private JTextField maxResult;
	private JTextField hp;
	private JTextField mp;
	private JTextField dex;
	private JTextField strength;
	private JTextField range;
	private JTextField artillery;
	private JTextField magic;
	private JTextField defense;
	private JTextField strBonus;
	private JTextField rangeBonus;
	private JTextField magicBonus;
	private JTextField artBonus;
	private JTextField defBonus;
	private JTextField playerLevel;
	private JTextField bookBonus;
	private JTextField totalStats;
	private JTextField totalCoins;
	private JTextField sellPercent;



	class pet{
		int power;
		int health;
		int defense;
		int dexterity;
		int cost;
		String name;
		String abil1,abil2,abil3,abil4;
		public pet(int p, int h, int d, int dx, int c, String n, String a1, String a2, String a3){
			power = p;
			health = h;
			defense = d;
			dexterity = dx;
			cost = c;
			name = n;
			abil1 = a1;
			abil2 = a2;
			abil3 = a3;
		}

	}
	class mob{
		int attack;
		int defense;
		int health;
		String name;
		public mob(int a, int d, int h, String n){
			attack = a;
			defense = d;
			health = h;
			name = n;
		}
	}
	class itemType{
		int level;
		int price;
		String group;
		String name;
		String location;

		public itemType(int i, int j, String string, String string2, String string3) {
			level =i;
			price = j;
			group = string;
			name = string2;
			location = string3;
		}

	}

	static itemType[] items;
	static mob[] monsters;
	static pet[] pets;
	private JTextField playerDefense;
	private JTextField damageTaken;
	private JTextField priceMin;
	private JTextField priceMax;
	private JTextField petAttk;
	private JTextField petDex;

	public static void main(String[] args) {






		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frmHelmetHeroesAssistant.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////

	public MainFrame() {

		pets = new pet[]{//power, health, defense, dexterity, cost, abilities 1-3
				new pet(4, 16, 2, 4, 200000, "tebra", "full attack", "full power attack", "half loot"),
				new pet(6, 23, 3, 1, 275000, "marshy", "full power attack", "full attack", "full on defensive"),
				new pet(2, 10, 1, 2, 150000, "baby bounce", "full loot", "half loot half attack", "25% pick up 75% attack"),
				new pet(2, 14, 1, 4, 170000, "petri", "full loot", "half loot half attack", "25% pick up 75% attack"),
				new pet(6, 26, 3, 2, 290000, "gibler", "full on defensive mode", "full attack", "half coin pickup 75% attack"),
				new pet(4, 17, 2, 7, 310000, "fisky","quick attack", "full loot", "increase luck"),
				new pet(3, 13, 6, 4, 305000, "roblost", "full power attack", "full attack", "full on defensive"),
				new pet(2, 12, 4, 2, 175000, "pumpman", "full on defensive", "half defensive half attack", "full attack"),
				new pet(3, 19, 2, 4, 200000, "chippy", "full attack", "25% pick up 75% attack", "increase luck"),
				new pet(3, 15, 2, 5, 195000, "thumper", "quick attack", "full loot", "half coin pickup 75% attack"),
				new pet(4, 30, 3, 4, 362500, "nooter", "full attack", "booster", "increase player dex"),
				new pet(2, 11, 1, 6, 180000, "gobloid", "full power attack", "increase luck", "full attack"),
				new pet(7, 28, 3, 1, 280000, "ritardo", "full extreme attack", "full power attack", "full attack"),
				new pet(7, 14, 2, 5, 300000, "ozich", "increase player dex", "quick attack", "full attack"),
				new pet(3, 18, 2, 3, 187500, "topper", "full attack", "booster", "half defensive half attack"),
				new pet(6, 15, 5, 2, 275000, "bunyan", "full on defensive", "half defensive half attack", "booster"),
				new pet(2, 19, 1, 4, 180000, "quackster", "increase player dex", "half coin pickup 75% attack", "increase luck"),
				new pet(7, 15, 4, 2, 235000, "dwimplepike", "full attack", "full power attack", "half loot half attack"),
				new pet(7, 20, 3, 4, 327500, "squatch", "full extreme attack", "full attack", "half loot half attack"),
				new pet(9, 24, 3, 3, 350000, "stalkling", "quick attack", "full loot", "half coin pickup 75% attack")
		};

		monsters = new mob[]{//attack,defense,health,name
				new mob(5, 2, 18,"green bouncer"),
				new mob(16, 8, 63,"green walker"),
				new mob(14, 6, 36,"purple goo"),
				new mob(31, 18, 80,"red bouncer"),
				new mob(10, 6, 28,"mushroom squish"),
				new mob(44, 36, 130, "mushroom ball"),
				new mob(90, 88, 600,"bouncing mushroom"),
				new mob(46, 46, 210,"orange crazy"),
				new mob(11, 8, 55,"yellow hairy monster"),
				new mob(130, 104, 670,"yellow puff monster"),
				new mob(50, 52, 240,"horned monster"),
				new mob(55, 56, 280,"crab"),
				new mob(153, 110, 800,"plant monster"),
				new mob(74, 92, 750,"pumpkin creeper"),
				new mob(220, 140, 1800,"great frog"),
				new mob(122, 120, 580,"penguin"),
				new mob(278, 160, 4200,"sasquatch"),
				new mob(95, 104, 12000,"goo cube"),
				new mob(330, 230, 7000,"brick monster"),
				new mob(192, 185, 1600,"block bot"),
				new mob(227, 180, 2700,"night stalker"),
				new mob(365, 240, 6400,"drill bot"),
				new mob(550, 250, 16000,"lotus eye"),
				new mob(720, 280, 24000,"dark beholder"),
				new mob(772, 200, 131000,"carnelia"),
				new mob(185, 170, 1500,"leafling"),
				new mob(9, 9, 34,"leaflet"),
				new mob(475, 246, 10000,"glord"),
				new mob(690, 340, 30000,"kreeton"),
				new mob(180, 100, 210000,"giant goo cube"),
				new mob(1400, 380, 155000, "repguana"),
				new mob(1900, 360, 4000000, "kreetus"),
				new mob(44, 66, 205, "fishum"),
				new mob(2200, 460, 270000, "proteum"),
				new mob(255, 175, 2000, "bionic bird"),
				new mob(2800, 640, 350000, "titanium vulture"),
				new mob(4000, 850, 500000, "magmagon")
		};


		//item Catalog 
		//level, price, class, name, location) class, 0=special 1=warrior 2=mage 3=archer 4=gunslinger
		items = new itemType[]{
				new itemType( 105,318000, "archer","achilles armor" , "travis"),
				new itemType( 60,40000, "archer","achilles boot" , "sam"),
				new itemType( 104,345000, "archer","achilles helmet" , "travis"),
				new itemType( 100,290000, "archer","achilles legs" , "travis"),
				new itemType( 47,30000, "warrior","adamantium armor" , "wallace"),
				new itemType( 50,45000, "warrior","adamantium helmet" , "wallace"),
				new itemType( 43,24000, "warrior","adamantium legs" , "wallace"),
				new itemType( 93,320000, "archer","alloy wolf helmet" , "tiberius"),
				new itemType( 60,75000, "warrior","ancient armor" , "chance"),
				new itemType( 59,55000, "warrior","ancient battle axe" , "wallace"),
				new itemType( 70,135000, "warrior","ancient helmet" , "chance"),
				new itemType( 56,65000, "warrior","ancient legs" , "chance"),
				new itemType( 61,82000, "warrior","ancient shield" , "shane"),
				new itemType( 26,15000, "archer","angel wings bow" , "snoop"),
				new itemType( 19,9000, "archer","apollos armor" , "tiberius"),
				new itemType( 18,6000, "archer","apollos armor legs" , "tiberius"),
				new itemType( 24,15000, "archer","apollos helmet" , "tiberius"),
				new itemType( 0,50, "special","apple" , "geraldo"),
				new itemType( 115,380000, "archer","archaic armor" , "anoop"),
				new itemType( 72,60000, "archer","archaic boot" , "sam"),
				new itemType( 110,360000, "archer","archaic bow" , "anoop"),
				new itemType( 112,412000, "archer","archaic helmet" , "anoop"),
				new itemType( 113,356000, "archer","archaic legs" , "anoop"),
				new itemType( 5,1600, "archer","archer hat" , "heath"),
				new itemType( 10,3200, "archer","archer leather legs", "alpipa"),
				new itemType( 5,1600, "mage","archer pants" , "carter"),
				new itemType( 15,3500, "archer","archer patches hat" , "snoop"),
				new itemType( 5,1700, "archer","archer shirt" , "carter"),
				new itemType( 74,147000, "warrior","armor of hatred" , "sneed"),
				new itemType( 18,6500, "warrior","army helmet" , "alpipa"),
				new itemType( 68,125000, "archer","assault armor" , "viper"),
				new itemType( 45,24000, "archer","assault boots" , "sam"),
				new itemType( 74,173000, "archer","assault helmet" , "viper"),
				new itemType( 67,111000, "archer","assault legs" , "viper"),
				new itemType( 96,290000, "mage","astro helmet" , "viper"),
				new itemType( 78,160000, "mage","astro legs" , "viper"),
				new itemType( 84,170000, "mage","astro suit" , "viper"),
				new itemType( 65,82000, "warrior","axe of minions" , "wallace"),
				new itemType( 12,5400, "mage","ballerina outfit" , "rita"),
				new itemType( 1,320, "mage","ballerina stockings" , "rita"),
				new itemType( 0,35, "special","banana" , "geraldo"),
				new itemType( 85,161000, "warrior","barbarian axe of fire" , "wallace"),
				new itemType( 6,2500, "mage","basic magic staff" , "anoop"),
				new itemType( 2,300, "mage","basic wand" , "anoop"),
				new itemType( 40,45000, "mage","bat wing staff" , "chance"),
				new itemType( 122,457000, "warrior","beholder armor" , "chance"),
				new itemType( 126,450000, "warrior","beholder axe" , "wallace"),
				new itemType( 74,90000, "warrior","beholder boot" , "sam"),
				new itemType( 101,280000, "warrior","beholder bow" , "wallace"),
				new itemType( 130,590000, "warrior","beholder helmet" , "chance"),
				new itemType( 116,358000, "warrior","beholder legs" , "chance"),
				new itemType( 113,290000, "warrior","beholder shield" , "shane"),
				new itemType( 89,210000, "warrior","beholder staff" , "wallace"),
				new itemType( 125,270000, "warrior","beholder sword" , "wallace"),
				new itemType( 84,175000, "warrior","beholder wand" , "wallace"),
				new itemType( 1,105, "warrior","big stick" , ""),
				new itemType( 90,220000, "warrior","blade of hatred" , "sneed"),
				new itemType( 2,140, "mage","blue beanie" , "heath"),
				new itemType( 63,78000, "mage","blue crystal armor" , "viper"),
				new itemType( 40,16000, "mage","blue crystal boot" , "sam"),
				new itemType( 77,161000, "mage","blue crystal helmet" , "viper"),
				new itemType( 59,72300, "mage","blue crystal legs" , "viper"),
				new itemType( 23,8200, "warrior","blue face helmet" , "alpipa"),
				new itemType( 4,530, "mage","blue jeans" , "heath"),
				new itemType( 7,1200, "mage","blue magic shoe" , "sam"),
				new itemType( 2,170, "warrior","blue plastic sword" , "heath"),
				new itemType( 3,329, "mage","blue shirt" , ""),
				new itemType( 13,5800, "mage","blue sphere staff" , "alpipa"),
				new itemType( 13,4000, "mage","blue wizard pants" , "tiberius"),
				new itemType( 34,11000, "mage","blue wizard belt hat" , "anoop"),
				new itemType( 30,8000, "mage","blue wizard hat" , "anoop"),
				new itemType( 16,6000, "mage","blue wizard robe" , "tiberius"),
				new itemType( 4,600, "archer","body wrap" , ""),
				new itemType( 4,650, "warrior","bone" , ""),
				new itemType( 4,470, "warrior","bronze dagger" , "heath"),
				new itemType( 23,8000, "warrior","bronze plate armor" , "snoop"),
				new itemType( 22,6800, "warrior", "bronze plate legs", "snoop"),
				new itemType( 17,6200, "warrior","bronze shield" , "shane"),
				new itemType( 1,110, "warrior","brown shoes" , "heath"),
				new itemType( 5,1700, "mage","brown wizard pants" , "anoop"),
				new itemType( 5,1800, "mage","brown wizard robe" , "anoop"),
				new itemType( 15,4200, "warrior","bucket helmet" , ""),
				new itemType( 58,63000, "warrior","captains rapier" , "wallace"),
				new itemType( 25,6000, "archer","cat hat" , "rita"),
				new itemType( 64,95000, "warrior","chain armor" , "chance"),
				new itemType( 74,160000, "warrior","chain helmet" , "chance"),
				new itemType( 61,82000, "warrior","chain legs" , "chance"),
				new itemType( 15,5000, "warrior","chainmail" , "alpipa"),
				new itemType( 15,4500, "warrior","chainmail legs" , "alpipa"),
				new itemType( 38,15000, "mage","charm hat" , "rita"),
				new itemType( 19,5300, "warrior","chunk mace" , "snoop"),
				new itemType( 9,2000, "warrior","claw" , ""),
				new itemType( 2,900, "archer","clover hat" , "heath"),
				new itemType( 13,2900, "warrior","coconut leaves helmet" , "carter"),
				new itemType( 8,1750, "warrior","coconut armor" , "carter"),
				new itemType( 7,1800, "warrior","coconut helmet" , "carter"),
				new itemType( 7,1650, "warrior","coconut kneepads" , "carter"),
				new itemType( 54,50000, "warrior","cone helmet" , "travis"),
				new itemType( 5,1300, "mage","crumby wizard hat" , "anoop"),
				new itemType( 65,100000, "warrior","crusader helmet" , "chance"),
				new itemType( 46 ,45000, "archer","crypt fire bow" , "wallace"),
				new itemType( 37,29000, "special","crystal heart shield" , "shane"),
				new itemType( 37,25000, "mage","cursed pants" , "travis"),
				new itemType( 40,31000, "mage","cursed robe" , "travis"),
				new itemType( 8,4500, "mage","cursed shoe" , "sam"),
				new itemType( 77,170000, "archer","cyborg armor" , "viper"),
				new itemType( 83,205000, "archer","cyborg bow" , "sneed"),
				new itemType( 81,210000, "archer","cyborg helmet" , "viper"),
				new itemType( 75,152000, "archer","cyborg legs" , "viper"),
				new itemType( 46,55000, "warrior","death bringer" , "alpipa"),
				new itemType( 52,40000, "warrior","demons fury" , "wallace"),
				new itemType( 51,67000, "archer","diamond studded bow", "travis"),
				new itemType( 96,265000, "warrior","dino blade" , "sneed"),
				new itemType( 90,285000, "warrior","dino helmet" , "sneed"),
				new itemType( 81,190000, "warrior","dino scale armor" , "sneed"),
				new itemType( 81,159000, "warrior","dino scale legs" , "sneed"),
				new itemType( 83,155000, "warrior","dino shield" , "shane"),
				new itemType( 17,4500, "archer","double bell shoe" , "sam"),
				new itemType( 29,22000, "archer","eagle slingshot" , "viper"),
				new itemType( 27,17000, "mage","eagle staff" , "tiberius"),
				new itemType( 70,90000, "warrior","electric infuriator" , "wallace"),
				new itemType( 60,86000, "warrior","electric katana" , "wallace"),
				new itemType( 112,300000, "mage","element armor" , "carter"),
				new itemType( 65,6544000, "mage","element boot" , "sam"),
				new itemType( 123,439000, "mage","element helmet" , "carter"),
				new itemType( 106,280000, "mage","element legs" , "carter"),
				new itemType( 100,273000, "mage","element staff" , "carter"),
				new itemType( 95,246000, "mage","element wand" , "carter"),
				new itemType( 8,1300, "archer","elf bell shoe" , "anoop"),
				new itemType( 5,800, "archer","elf shoe" , "anoop"),
				new itemType( 44,40000, "mage","enchanted armor" , "chance"),
				new itemType( 65,90000, "mage","enchanted helmet" , "chance"),
				new itemType( 40,33000, "mage","enchanted legs" , "chance"),
				new itemType( 58,98000, "mage","fallen queens spectre" , "sneed"),
				new itemType( 7,1000, "warrior","fireman hatchet" , "anoop"),
				new itemType( 25,17000, "archer","fish scale armor" , "tiberius"),
				new itemType( 24,13000, "archer","fish scale legs" , "tiberius"),
				new itemType( 35,36000, "archer","flak jacket" , "travis"),
				new itemType( 69,148000, "archer","flaming needle bow" , "viper"),
				new itemType( 63,116000, "archer","frosters bow" , "sneed"),
				new itemType( 106,350000, "warrior","frosting trident" , "sneed"),
				new itemType( 3,500, "warrior","full ski mask" , "heath"),
				new itemType( 69,120000, "warrior","future armor" , "sneed"),
				new itemType( 40,23000, "warrior","future boot" , "sam"),
				new itemType( 78,195000, "warrior","future helmet" , "sneed"),
				new itemType( 65,95000, "warrior","future legs" , "sneed"),
				new itemType( 72,95000, "warrior","future shield" , "shane"),
				new itemType( 7,2500, "special","garbage can lid" , "shane"),
				new itemType( 55,51000, "mage","ghost mask" , "travis"),
				new itemType( 43,26000, "warrior","gold helmet", "tiberius"),
				new itemType( 40,22000, "warrior","gold plate armor" , "tiberius"),
				new itemType( 38,5950, "warrior","gold plate legs" , "tiberius"),
				new itemType( 1,80, "archer","green beanie" , ""),
				new itemType( 30,22000, "archer","green face helmet" , "travis"),
				new itemType( 1,200, "special","green pants" , "heath"),
				new itemType( 2,250, "special","green shirt" , ""),
				new itemType( 2,490, "special","green shoe" , "carter"),
				new itemType( 1,0, "special","green shorts" , ""),
				new itemType( 49,59000, "warrior","guardians warhammer" , "alpipa"),
				new itemType( 1,70, "special","hair flower" , "rita"),
				new itemType( 31,24000, "warrior","halberd" , "alpipa"),
				new itemType( 5,1200, "warrior","half coconut" , "heath"),
				new itemType( 2,300, "warrior","half ski mask" , "heath"),
				new itemType( 4,480, "warrior","hammer" , "heath"),
				new itemType( 4,550, "archer","head wrap" , ""),
				new itemType( 54,80000, "archer","heartstriker bow" , "chance"),
				new itemType( 50,75000, "mage","heated staff" , "sneed"),
				new itemType( 84,235000, "warrior","helmet of hatred" , "sneed"),
				new itemType( 12,2650, "warrior","hockey mask" , ""),
				new itemType( 45,30000, "warrior","horned helmet" , "travis"),
				new itemType( 87,285000, "special","hybrid helmet" , "chance"),
				new itemType( 81,125000, "warrior","ice blade of gods" , "wallace"),
				new itemType( 55,48000, "warrior","ice hammer" , "wallace"),
				new itemType( 101,345000, "warrior","imperial armor" , "sneed"),
				new itemType( 65,65000, "warrior","imperial boot" , "sam"),
				new itemType( 110,470000, "warrior","imperial helmet" , "sneed"),
				new itemType( 98,285000, "warrior","imperial legs" , "sneed"),
				new itemType( 40,36000, "mage","indian wand" , "viper"),
				new itemType( 88,240000, "archer","industrial armor" , "viper"),
				new itemType( 90,275000, "archer","industrial helmet" , "viper"),
				new itemType( 84,230000, "archer","industrial legs" , "viper"),
				new itemType( 36,19000, "mage","jester pants" , "travis"),
				new itemType( 40,25000, "mage","jester shirt" , "travis"),
				new itemType( 50,35000, "mage", "jester hat", "travis"),
				new itemType( 29,1200, "warrior","knight armor" , "snoop"),
				new itemType( 27,10000, "warrior","knight armor legs" , "snoop"),
				new itemType( 35,18000, "warrior","knight helmet" , "snoop"),
				new itemType( 13,3100, "archer","lazer shades" , "viper"),
				new itemType( 3,900, "archer","leaf bow" , "carter, anoop"),
				new itemType( 10,2800, "archer","leaf pad bow" , "anoop"),
				new itemType( 11,3400, "archer","leather archer armor" , "alpipa"),
				new itemType( 10,3000, "archer","leather armor" , "alpipa"),
				new itemType( 14,3400, "archer","leather helmet" , "alpipa"),
				new itemType( 10,2800, "archer","leather legs" , "alpipa"),
				new itemType( 70,128000, "warrior","legs of hatred" , "sneed"),
				new itemType( 75,110000, "warrior","light sword" , "sneed"),
				new itemType( 12,3100, "warrior","log splitting axe" , "carter"),
				new itemType( 9,1850, "warrior","machete" , "carter"),
				new itemType( 33,12000, "mage","magician armor" , "snoop"),
				new itemType( 28,7000, "mage","magician armor legs" , "snoop"),
				new itemType( 52,38000, "warrior","magnesium armor" , "wallace"),
				new itemType( 23,8000, "warrior","magnesium boots" , "sam"),
				new itemType( 60,65000, "warrior","magnesium helmet" , "wallace"),
				new itemType( 50,30000, "warrior","magnesium legs" , "wallace"),
				new itemType( 5,810, "warrior","meat cleaver" , "snoop"),
				new itemType( 30,22000, "archer","mechanic wing bow" , "snoop"),
				new itemType( 9,3000, "archer","medium bow" , "anoop"),
				new itemType( 40,48000, "warrior","mega sword" , "snoop"),
				new itemType( 34,16000, "mage","metal ballerina outfit" , "rita"),
				new itemType( 31,14000, "mage","metal ballerina legs" , "rita"),
				new itemType( 35,21000, "mage","metal cat helmet" , "rita"),
				new itemType( 26,5100, "mage","mocap pants" , "viper"),
				new itemType( 28,8500, "mage","mocap suit" , "viper"),
				new itemType( 15,4300, "warrior","monster skull" , ""),
				new itemType( 100,205000, "warrior","mummified axe" , "sneed"),
				new itemType( 61,75000, "mage","mushroom helmet" , "chance"),
				new itemType( 50,55000, "archer","natures bow" , "chance"),
				new itemType( 18,8400, "mage","natures staff" , "snoop"),
				new itemType( 90,225000, "mage","neon magic helmet" , "viper"),
				new itemType( 65,110000, "mage","neon magic legs" , "viper"),
				new itemType( 76,120000, "mage","neon magic suit" , "viper"),
				new itemType( 58,98000, "archer","night glow bow" , "chance"),
				new itemType( 34,16000, "mage","night glow wand", "travis"),
				new itemType( 23,13000, "mage","nightingale staff" , "snoop"),
				new itemType( 23,5000, "mage","nightingale wand" , "snoop"),
				new itemType( 34,28000, "mage", "ocean staff", "travis"),
				new itemType( 4,1350, "archer","oriental hat" , ""),
				new itemType( 12,3300, "warrior","pickaxe" , "carter"),
				new itemType( 63,80000, "mage","pink crystal armor" , "rita"),
				new itemType( 40,16000, "mage","pink crystal boot" , "sam"),
				new itemType( 77,170000, "mage","pink crystal helmet" , "rita"),
				new itemType( 60,71000, "mage","pink crystal legs" , "rita"),
				new itemType( 3,240, "warrior","plastic saber" , "heath"),
				new itemType( 46,80000, "mage","protector helmet" , "sneed"),
				new itemType( 40,47000, "mage","protector legs" , "sneed"),
				new itemType( 24,10500, "special","protector shield" , "shane"),
				new itemType( 44,58000, "mage","protector suit" , "sneed"),
				new itemType( 16,5000, "warrior","pumpkin helmet" , ""),
				new itemType( 17,6000, "warrior","racing helmet" , "alpipa"),
				new itemType( 86,185000, "warrior","reapers scythe" , "wallace"),
				new itemType( 1,200, "special","red beanie" , "heath"),
				new itemType( 4,150, "special","red pants" , ""),
				new itemType( 1,110, "warrior","red plastic sword" , "heath"),
				new itemType( 3,250, "special","red shirt" , "heath"),
				new itemType( 8,4000, "mage","red wizard hat" , "anoop"),
				new itemType( 8,2800, "mage","red wizard pants" , "anoop"),
				new itemType( 9,3200, "mage","red wizard robe" , "anoop"),
				new itemType( 32,26000, "archer","reinforced bush armor" , "travis"),
				new itemType( 31,21100, "archer","reinforced bush legs" , "travis"),
				new itemType( 100,239000, "mage","relic armor" , "travis"),
				new itemType( 53,28000, "mage","relic boot" , "sam"),
				new itemType( 110,380000, "mage","relic helmet" , "travis"),
				new itemType( 94,213000, "mage","relic legs" , "travis"),
				new itemType( 28,9000, "mage","reptile wand" , "tiberius"),
				new itemType( 19,11000, "archer","rich man’s bow" , "snoop"),
				new itemType( 90,250000, "warrior","robot armor" , "viper"),
				new itemType( 98,365000, "warrior","robot helmet" , "viper"),
				new itemType( 86,210000, "warrior","robot legs" , "viper"),
				new itemType( 92,220000, "special","robot shield" , "shane"),
				new itemType( 19,7000, "warrior","roman helmet" , "alpipa"),
				new itemType( 9,2400, "warrior","roman leggings" , "alpipa"),
				new itemType( 10,2800, "warrior","roman robe" , "alpipa"),
				new itemType( 48,52000, "mage","royal armor" , "sneed"),
				new itemType( 69,112000, "mage","royal helmet" , "sneed"),
				new itemType( 43,41000, "mage","royal legs" , "sneed"),
				new itemType( 12,2700, "warrior","rusty scimitar" , "carter"),
				new itemType( 5,800, "warrior","sai" , "anoop"),
				new itemType( 51,70000, "archer","samurai armor" , "sneed"),
				new itemType( 57,100000, "archer","samurai helmet" , "sneed"),
				new itemType( 50,60000, "archer","samurai legs" , "sneed"),
				new itemType( 3,350, "special","shades" , "tiberius"),
				new itemType( 68,145000, "mage","shaman staff" , "anoop"),
				new itemType( 55,90000, "mage","shaman wand" , "anoop"),
				new itemType( 6,800, "warrior","short sword" , "carter"),
				new itemType( 3,500, "warrior","sickle" , "heath"),
				new itemType( 17,3600, "warrior","single battle axe" , "alpipa"),
				new itemType( 109,255000, "warrior","single godly blade" , "tiberius"),
				new itemType( 83,143000, "warrior","single hatred blade" , "sneed"),
				new itemType( 10,2400, "mage","single sphere wand" , "alpipa"),
				new itemType( 140,576000, "warrior","skull crusher" , "wallace"),
				new itemType( 133,550000, "warrior","skull crusher armor" , "chance"),
				new itemType( 85,150000, "warrior","skull crusher boot" , "sam"),
				new itemType( 145,700000, "warrior","skull crusher helmet" , "chance"),
				new itemType( 127,435000, "warrior","skull crusher legs" , "chance"),
				new itemType( 124,370000, "warrior","skull crusher shield" , "shane"),
				new itemType( 24,12500, "warrior","skull spear" , "tiberius"),
				new itemType( 11,2800, "warrior","sledgehammer" , "carter"),
				new itemType( 1,234, "archer","slingshot" , ""),
				new itemType( 1,500, "archer","small bow" , "heath"),
				new itemType( 134,350000, "warrior","small skull crusher" , "wallace"),
				new itemType( 11,3400, "special","smiley tin shield" , "shane"),
				new itemType( 62,80000, "warrior","snout zinc helmet" , "wallace"),
				new itemType( 34,16000, "mage","sorcerer pants" , "travis"),
				new itemType( 38,20000, "mage","sorcerer robe" , "travis"),
				new itemType( 45,26000, "mage","sorcerers copter hat" , "travis"),
				new itemType( 40,19000, "mage","sorcerer hat and glasses" , "travis"),
				new itemType( 32,15000, "warrior","spartan helmet" , "snoop"),
				new itemType( 44,57000, "mage","spherical staff" , "sneed"),
				new itemType( 50,37000, "warrior","spiked dino boots" , "sam"),
				new itemType( 41,65000, "archer","spiked shell helmet" , "travis"),
				new itemType( 7,1200, "mage","star wand" , "anoop"),
				new itemType( 15,3000, "warrior","steel boot" , "sam"),
				new itemType( 33,29000, "archer","steel helmet hat" , "travis"),
				new itemType( 1,50, "warrior","stick" , ""),
				new itemType( 34,15000, "warrior","stone armor" , "tiberius"),
				new itemType( 31,13500, "warrior","stone armor legs" , "tiberius"),
				new itemType( 37,22000, "warrior","stone helmet" , "tiberius"),
				new itemType( 30,15600, "special","stone shield" , "shane"),
				new itemType( 9,2900, "special","stop sign" , "shane"),
				new itemType( 39,46000, "archer","strong armor" , "chance"),
				new itemType( 37,14000, "special","strong basket helmet" , "snoop"),
				new itemType( 42,53000, "archer","strong full helmet" , "chance"),
				new itemType( 37,38000, "archer","strong legs" , "chance"),
				new itemType( 26,10000, "warrior","sugarloaf helmet" , "alpipa"),
				new itemType( 5,620, "special","suit" , "carter"),
				new itemType( 4,610, "special","suit pants" , "carter"),
				new itemType( 32,16000, "warrior","super hero shirt" , "tiberius"),
				new itemType( 12,4200, "warrior","scythe" , "alpipa"),
				new itemType( 21,9900, "warrior","teardrop blade" , "alpipa"),
				new itemType( 15,8300, "archer","thorn bow" , "anoop"),
				new itemType( 8,2000, "archer","triple leaf bow" , "carter, anoop"),
				new itemType( 37,34000, "mage","tropical staff" , "travis"),
				new itemType( 0,300, "special","turkey" , "geraldo"),
				new itemType( 23,11000, "warrior","two hand mace" , "snoop"),
				new itemType( 8,1800, "warrior","umbrella" , "rita"),
				new itemType( 46,54000, "mage","wand of blessing" , "sneed"),
				new itemType( 0,120, "special","watermelon" , "geraldo"),
				new itemType( 1,125, "special","white shirt" , ""),
				new itemType( 1,50, "special","white shoes" , ""),
				new itemType( 36,25000, "mage","winged diamond wand" , "chance"),
				new itemType( 36,13000, "mage","witch hat" , "tiberius"),
				new itemType( 58,65000, "mage","wizard hat mask" , "chance"),
				new itemType( 15,4200, "special","wood metal shield" , "shane"),
				new itemType( 7,2000, "special","wood scrap shield" , "shane"),
				new itemType( 5,720, "warrior","wooden bat" , "carter"),
				new itemType( 14,4900, "warrior","wooden spear" , "tiberius"),
				new itemType( 4,650, "special","wrapped legs" , ""),
				new itemType( 2,300, "special","yellow pants" , "heath"),
				new itemType( 55,51000, "warrior","zinc armor" , "wallace"),
				new itemType( 27,14000, "warrior","zinc boots" , "sam"),
				new itemType( 52,46000, "warrior","zinc legs" , "wallace"),
				new itemType( 0,55000, "special","book of power" , "lewis"),
				new itemType( 0,55000, "special","book of magic" , "lewis"),
				new itemType( 0,55000, "special","book of range" , "lewis"),
				new itemType( 0,55000, "special","book of dexterity" , "lewis"),
				new itemType( 0,55000, "special","book of health" , "lewis"),
				new itemType( 0,55000, "special","book of mp" , "lewis"),
				new itemType( 0,55000, "special","book of defense" , "lewis"),
				new itemType( 0,210000, "special","book of skill" , "lewis"),
				new itemType( 128,445000, "archer","harpoon bow" , "ricardo"),
				new itemType( 109,305000, "mage","analytic wand" , "ricardo"),
				new itemType( 117,360000, "mage","analytic staff" , "ricardo"),
				new itemType( 138,385000, "mage","serpent wand" , "ricardo"),
				new itemType( 142,443000, "mage","serpent staff" , "ricardo"),
				new itemType( 163,440000, "warrior","acidic sword" , "ricardo"),
				new itemType( 171,700000, "warrior","two hand acid blade" , "ricardo"),
				new itemType( 153,460000, "special","acid shield" , "ricardo"),
				new itemType( 174,750000, "warrior","thors hammer" , "ricardo"),
				new itemType( 47,32000, "warrior","deep sea helmet" , "ricardo"),
				new itemType( 135,505000, "archer","earth helmet" , "ricardo"),
				new itemType( 142,510000, "mage","analytic helmet" , "ricardo"),
				new itemType( 184,700000, "mage","serpent helmet" , "ricardo"),
				new itemType( 167,835000, "warrior","titanium helmet" , "ricardo"),
				new itemType( 154,645000, "warrior","titanium armor" , "ricardo"),
				new itemType( 153,525000, "warrior","titanium legs" , "ricardo"),
				new itemType( 138,460000, "archer","earth armor" , "ricardo"),
				new itemType( 144,435000, "archer","earth legs" , "ricardo"),
				new itemType( 135,375000, "mage","analytic armor" , "ricardo"),
				new itemType( 138,357000, "mage","analytic legs" , "ricardo"),
				new itemType( 179,550000, "mage","serpent armor" , "ricardo"),
				new itemType( 173,470000, "mage","serpent legs" , "ricardo"),
				new itemType( 184,1050000, "warrior","acidic helmet" , "ricardo"),
				new itemType( 185,800000, "warrior","acidic armor" , "ricardo"),
				new itemType( 184,650000, "warrior","acidic legs" , "ricardo"),
				new itemType( 1,200, "special","pet striped beanie" , "val"),
				new itemType( 1,90, "special","pet bowtie" , "val"),
				new itemType( 4,1150, "special","pet melon helmet" , "val"),
				new itemType( 5,1500, "special","pet oriental hat" , "val"),
				new itemType( 4,1900, "special","pet archer hat" , "val"),
				new itemType( 6,1300, "special","pet crumby hat" , "val"),
				new itemType( 16,5500, "special","pet army helmet" , "val"),
				new itemType( 24,2300, "special","pet wizard hat" , "val"),
				new itemType( 33,12500, "special","pet witch hat" , "val"),
				new itemType( 27,12000, "special","pet spartan helmet" , "val"),
				new itemType( 33,19000, "special","pet stone helmet" , "val"),
				new itemType( 23,13000, "special","pet apollo helmet" , "val"),
				new itemType( 35,35000, "special","pet strong helmet" , "val"),
				new itemType( 56,98000, "special","pet samurai helmet" , "val"),
				new itemType( 48,33000, "special","pet jester hat" , "val"),
				new itemType( 40,30000, "special","pet horned helmet" , "val"),
				new itemType( 51,46000, "special","pet cone helmet" , "val"),
				new itemType( 45,38000, "special","pet adamantium helmet" , "val"),
				new itemType( 87,275000, "special","pet dino scale helmet" , "val"),
				new itemType( 76,180000, "special","pet cyborg helmet" , "val"),
				new itemType( 117,385000, "special","pet element helmet" , "val"),
				new itemType( 121,510000, "special","pet beholder helmet" , "val"),
				new itemType( 43,70000, "special","pet protector helmet" , "val"),
				new itemType( 2,275, "special","paper bag", "heath"),
				new itemType( 4,700, "mage","santa claus hat", ""),
				new itemType( 208,1350000, "warrior","kreeton helmet", "bartholomew"),
				new itemType( 204,820000, "warrior","kreeton legs", "bartholomew"),
				new itemType( 208,995000, "warrior","kreeton armor", "bartholomew"),
				new itemType( 190,525000, "warrior","kreeton cutter", "bartholomew"),
				new itemType( 201,860000, "warrior","eye of kreeton", "bartholomew"),
				new itemType( 189,551000, "special","kreeton shield", "bartholomew"),
				new itemType( 101,95000, "archer","earth boot", "sam"),
				new itemType( 90,80000, "mage","serpent boot", "sam"),
				new itemType( 110,210000, "warrior","acid boot", "sam"),
				new itemType( 160,400000, "warrior","bladed boot", "sam"),
				new itemType( 263,1500000, "warrior","electric barracuda", "bartholemew"),
				new itemType( 246,900000, "warrior","brooding fire axe", "bartholemew"),
				new itemType( 258,1500000, "warrior","bladed legs", "bartholemew"),
				new itemType( 260,1700000, "warrior","bladed armor", "bartholemew"),
				new itemType( 263,2150000, "warrior","bladed helmet", "bartholemew"),
				new itemType( 179,880000, "archer","repguana bow", "bartholemew"),
				new itemType( 189,840000, "archer","repguana legs", "bartholemew"),
				new itemType( 189,1000000, "archer","repguana armor", "bartholemew"),
				new itemType( 189,1100000, "archer","reguana helmet", "bartholemew"),
				new itemType( 192,800000, "mage","darkane staff", "bartholemew"),
				new itemType( 177,680000, "mage","darkane wand", "bartholemew"),
				new itemType( 222,875000, "mage","darkane legs", "bartholemew"),
				new itemType( 223,1050000, "mage","darkane armor", "bartholemew"),
				new itemType( 233,1300000, "mage","darkane hood helmet", "bartholemew"),
				new itemType( 1,280, "cowboy","airsoft gun", "heath"),
				new itemType( 2,550, "cowboy","paintball gun", "heath"),
				new itemType( 1,160, "cowboy","paper hat", "heath"),
				new itemType( 4,560, "cowboy","koon hat", "heath"),
				new itemType( 5,1250, "cowboy","detective hat", "heath"),
				new itemType( 20,8100, "cowboy","cowboy hat", "heath"),
				new itemType( 9,2900, "cowboy","cowboy shirt", "heath"),
				new itemType( 9,2500, "cowboy","cowboy pants", "heath"),
				new itemType( 18,10500, "cowboy","revolver", "snoop"),
				new itemType( 26,17000, "cowboy","mac10", "snoop"),
				new itemType( 31,25000, "cowboy","mp5", "snoop"),
				new itemType( 5,1710, "cowboy","mexican shirt", "snoop"),
				new itemType( 4,1650, "cowboy","mexican pants", "snoop"),
				new itemType( 8,4300, "cowboy","sombrero", "snoop"),
				new itemType( 12,4900, "cowboy","koon outfit", "snoop"),
				new itemType( 11,4300, "cowboy","koon pants", "snoop"),
				new itemType( 36,15000, "cowboy","masked cowboy hat", "snoop"),
				new itemType( 76,156000, "cowboy","cowboy knight helmet", "chance"),
				new itemType( 66,83000, "cowboy","steel masked helmet", "chance"),
				new itemType( 53,35050, "cowboy","pointed pirate hat", "chance"),
				new itemType( 55,85000, "cowboy","m16", "wallace"),
				new itemType( 83,200000, "cowboy","sniper rifle", "wallace"),
				new itemType( 40,41000, "cowboy","shotgun", "tiberius"),
				new itemType( 53,70000, "cowboy","tommy gun", "tiberius"),
				new itemType( 58,100000, "cowboy","es c90", "tiberius"),
				new itemType( 62,115000, "cowboy","ak47", "tiberius"),
				new itemType( 91,220000, "cowboy","chemical mask", "tiberius"),
				new itemType( 27,11500, "cowboy","cowboy belt hat", "carter"),
				new itemType( 14,8200, "cowboy","handgun", "carter"),
				new itemType( 8,2900, "cowboy","potato gun", "carter"),
				new itemType( 100,274000, "cowboy","xm8 rifle", "ricardo"),
				new itemType( 111,350000, "cowboy","machine gun", "ricardo"),
				new itemType( 128,420000, "cowboy","chaingun", "ricardo"),
				new itemType( 170,650000, "cowboy","bazooka", "ricardo"),
				new itemType( 189,850000, "cowboy","rayon gun", "ricardo"),
				new itemType( 7,1250, "cowboy","cowboy boot", "sam"),
				new itemType( 20,5000, "cowboy","pirate boot", "sam"),
				new itemType( 45,22000, "cowboy","chemical boot", "sam"),
				new itemType( 100,101000, "cowboy","valor boot", "sam"),
				new itemType( 18,8000, "special","pet cowboy hat", "val"),
				new itemType( 38,25000, "special","pet pirate hat", "val"),
				new itemType( 125,500000, "special","pet valor helmet", "val"),
				new itemType( 200,800000, "special","pet pirate helmet", "val"),
				new itemType( 0,55000, "cowboy","book of artillery", "lewis"),
				new itemType( 7,700, "special","fishing pole", "milton"),
				new itemType( 6,30, "special","fishing net", "payvault"),
				new itemType( 0,35, "special","palm tree log", "tree"),
				new itemType( 0,180, "special","purple tree log", "tree"),
				new itemType( 0,87, "special","weeping willow log", "tree"),
				new itemType( 0,28, "special","dead tree log", "tree"),
				new itemType( 0,36, "special","blue mushroom log", "tree"),
				new itemType( 0,36, "special","red mushroom log", "tree"),
				new itemType( 0,24, "special","goof tree log", "tree"),
				new itemType( 0,42, "special","chestnut tree log", "tree"),
				new itemType( 0,115, "special","pine tree log", "tree"),
				new itemType( 0,150, "special","jungle tree log", "tree"),
				new itemType( 0,49, "special","robot tree log", "tree"),
				new itemType( 0,45, "special","tropical tree log", "tree"),
				new itemType( 0,210, "special","thorn tree log", "tree"),
				new itemType( 0,45, "special","snowy tree log", "tree"),
				new itemType( 370,5600000, "warrior","mithril helmet", "jerry"),
				new itemType( 355,4100000, "warrior","mithril armor", "jerry"),
				new itemType( 354,4700000, "warrior","mithril legs", "jerry"),
				new itemType( 325,4100000, "mage","phantom hood", "jerry"),
				new itemType( 320,3900000, "mage","phantom robe", "jerry"),
				new itemType( 320,3600000, "mage","phantom pants", "jerry"),
				new itemType( 310,5100000, "archer","divine helmet", "jerry"),
				new itemType( 315,3800000, "archer","divine armor", "jerry"),
				new itemType( 311,3650000, "archer","divine legs", "jerry"),
				new itemType( 325,3800000, "cowboy","enforcer helmet", "scott"),
				new itemType( 328,4055000, "cowboy","enforcer armor", "scott"),
				new itemType( 318,3850000, "cowboy","enforcer legs", "scott"),
				new itemType( 375,6400000, "warrior","frozen mithril axe", "scott"),
				new itemType( 360,3100000, "warrior","god dagger", "scott"),
				new itemType( 301,2600000, "mage","phantom wand", "scott"),
				new itemType( 320,3700000, "mage","phantom staff", "scott"),
				new itemType( 300,3550000, "archer","divine bow", "scott"),
				new itemType( 360,4000000, "special","mithril shield", "scott"),
				new itemType( 353,5050000, "cowboy","enforcer gun", "wood man steve"),
				new itemType( 0,7000, "special","robot bar", "wood man steve"),
				new itemType( 0,6200, "special","jungle wood", "wood man steve"),
				new itemType( 0,5500, "special","stacked wood", "wood man steve"),
				new itemType( 0,7100, "special","thorn wood", "wood man steve"),
				new itemType( 0,6300, "special","snow covered wood", "wood man steve"),
				new itemType( 0,5000, "special","palm tree wood", "wood man tim"),
				new itemType( 0,4500, "special","blue mushroom cube", "wood man tim"),
				new itemType( 0,4400, "special","red mushroom cube", "wood man tim"),
				new itemType( 0,5400, "special","purple sheet wood", "wood man tim"),
				new itemType( 0,5800, "special","willow wood", "wood man tim"),
				new itemType( 0,4900, "special","junk wood", "wood man tim"),
				new itemType( 0,4700, "special","colored wood", "wood man tim"),
				new itemType( 0,6000, "special","chestnut wood", "wood man tim"),
				new itemType( 0,5800, "special","pine block", "wood man tim"),
				new itemType( 2,85, "special","chicken hat", "payvault"),
				new itemType( 3,85, "special","chicken outfit", "payvault"),
				new itemType( 2,85, "special","chicken pants", "payvault"),
				new itemType( 70,13, "special","chainsaw", "payvault"),
				new itemType( 435, 7500000, "warrior","cyro thorn blade", "dan"),
				new itemType( 453, 12500000, "warrior","cyro x force", "dan"),
				new itemType( 375, 7100000, "archer","mystic tribal bow", "dan"),
				new itemType( 373, 5900000, "mage","hydro tech wand", "dan"),
				new itemType( 390, 8050000, "mage","hydro tech staff", "dan"),
				new itemType( 395, 9050000, "cowboy","skull bone gun", "dan"),
				new itemType( 371, 7300000, "cowboy","atomic helmet", "hubert"),
				new itemType( 375, 8200000, "archer","mystical tribal mask", "hubert"),
				new itemType( 390, 8800000, "mage","hydro tech helmet", "hubert"),
				new itemType( 450, 9400000, "warrior","cyro helmet", "hubert"),
				new itemType( 365, 6900000, "cowboy","atomic suit", "hubert"),
				new itemType( 367, 7650000, "archer","mystical tribal armor", "hubert"),
				new itemType( 385, 7250000, "mage","hydro tech suit", "hubert"),
				new itemType( 430, 8100000, "warrior","cyro armor", "hubert"),
				new itemType( 360, 6700000, "cowboy","atomic legs", "dan"),
				new itemType( 360, 7200000, "archer","mystical tribal legs", "dan"),
				new itemType( 381, 7000000, "mage","hydro tech legs", "dan"),
				new itemType( 425, 7700000, "warrior","cyro legs", "hubert"),
				new itemType( 168, 550000, "mage","hydro tech boot", "sam"),
				new itemType( 170, 500000, "archer","mystical tribal boot", "sam"),
				new itemType( 200, 615000, "cowboy","atomic boot", "sam"),
				new itemType( 225, 1200000, "warrior","cyro boot", "sam"),
				new itemType( 440, 12110000, "special","cyro shield", "shane"),
				new itemType( 1, 65, "special","monkey tail", "payvault"),
				new itemType( 15, 80, "special","red cape", "payvault"),
				new itemType( 25, 75, "special","jetpack", "payvault"),
				new itemType( 55, 70, "special","dino tail", "payvault"),
				new itemType( 65, 145, "special","wings", "payvault")
		};

		initialize();
	}

	private void initialize() {
		frmHelmetHeroesAssistant = new JFrame();
		frmHelmetHeroesAssistant.setBackground(new Color(0, 102, 51));
		frmHelmetHeroesAssistant.setFont(new Font("Dialog", Font.BOLD, 12));
		frmHelmetHeroesAssistant.setTitle("Helmet Heroes Assistant v3.0");
		frmHelmetHeroesAssistant.getContentPane().setBackground(new Color(0, 102, 51));
		frmHelmetHeroesAssistant.setBounds(100, 100, 800, 375);
		frmHelmetHeroesAssistant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHelmetHeroesAssistant.getContentPane().setLayout(null);
		frmHelmetHeroesAssistant.setVisible(true);

		JTabbedPane mainPane = new JTabbedPane(JTabbedPane.RIGHT);
		mainPane.setBackground(new Color(153, 255, 102));
		mainPane.setBorder(null);
		mainPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		mainPane.setBounds(0, 0, 784, 336);
		frmHelmetHeroesAssistant.getContentPane().add(mainPane);

		JPanel about = new JPanel();
		about.setBackground(new Color(0, 153, 51));
		mainPane.addTab("About", null, about, "Info on this application and it's author.");
		mainPane.setEnabledAt(0, true);
		about.setLayout(null);

		TextArea textArea_1 = new TextArea();
		textArea_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		textArea_1.setBackground(new Color(0, 204, 51));
		textArea_1.setText("Welcome to the Helmet Heroes Assistant v3.0!\r\n\r\nThis is a program designed to help you optimize your Helmet Heroes experience through \r\nseveral guides and calculators.\r\n\r\nNew in this version:\r\n   - Several small bug fixes.\r\nGraphical User Interface for:\r\n   - Merchant Calculator\r\n   - Items by Level\r\n   - Monster Damage Calculator\r\n   - Level Experience Calculator\r\n   - Merchant Calculator\r\n   - Damage Calculator (Basic)\r\n   - Items by Level\r\n   - Stat Allocation Guide\r\n   - Search Function\r\n\r\nWorking On:\r\n  - Pet Damage Calculator\r\n  - Fishing Guide\r\n  - Pet Guide");
		textArea_1.setEditable(false);
		textArea_1.setBounds(10, 10, 584, 311);
		about.add(textArea_1);

		JPanel LvlExpCalc = new JPanel();
		LvlExpCalc.setBackground(new Color(0, 153, 51));
		mainPane.addTab("Level Experience Calculator", null, LvlExpCalc, null);
		mainPane.setEnabledAt(1, true);
		LvlExpCalc.setLayout(null);

		curLevel = new JTextField();
		curLevel.setColumns(10);
		curLevel.setBounds(10, 11, 86, 20);
		LvlExpCalc.add(curLevel);

		JLabel label = new JLabel("Current Level");
		label.setBounds(106, 14, 89, 14);
		LvlExpCalc.add(label);

		goalLevel = new JTextField();
		goalLevel.setColumns(10);
		goalLevel.setBounds(10, 42, 86, 20);
		LvlExpCalc.add(goalLevel);

		JLabel label_1 = new JLabel("Goal Level");
		label_1.setBounds(106, 45, 89, 14);
		LvlExpCalc.add(label_1);

		curExp = new JTextField();
		curExp.setColumns(10);
		curExp.setBounds(10, 73, 86, 20);
		LvlExpCalc.add(curExp);

		JLabel label_2 = new JLabel("Current Experience to Next Level");
		label_2.setBounds(106, 76, 193, 14);
		LvlExpCalc.add(label_2);

		JButton compute = new JButton("Compute");
		compute.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					int currentLvl, goalLvl, currentExp;
					currentLvl = Integer.parseInt(curLevel.getText());
					goalLvl = Integer.parseInt(goalLevel.getText());
					currentExp = Integer.parseInt(curExp.getText());

					result.setText(Long.toString(lvlCalc(currentLvl, goalLvl, currentExp)));
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, "Please enter a valid number.");
				}


			}
		});
		compute.setFont(new Font("Segoe UI", Font.BOLD, 12));
		compute.setBackground(new Color(0, 255, 102));
		compute.setBounds(10, 139, 89, 23);
		LvlExpCalc.add(compute);

		JButton clear = new JButton("Clear");
		clear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				curLevel.setText(null);
				goalLevel.setText(null);
				curExp.setText(null);
				result.setText(null);

			}
		});
		clear.setFont(new Font("Segoe UI", Font.BOLD, 12));
		clear.setBackground(new Color(0, 255, 102));
		clear.setBounds(10, 181, 89, 23);
		LvlExpCalc.add(clear);

		result = new JTextField();
		result.setFont(new Font("Tahoma", Font.BOLD, 12));
		result.setEditable(false);
		result.setColumns(10);
		result.setBackground(new Color(102, 204, 102));
		result.setBounds(118, 141, 119, 20);
		LvlExpCalc.add(result);

		JLabel label_3 = new JLabel("Experience Needed to Reach Goal");
		label_3.setBounds(247, 144, 193, 14);
		LvlExpCalc.add(label_3);

		JPanel merchCalc = new JPanel();
		merchCalc.setBackground(new Color(0, 153, 51));
		mainPane.addTab("Merchant Calculator", null, merchCalc, null);
		mainPane.setEnabledAt(2, true);
		merchCalc.setLayout(null);


		/////////////////////////////////////////////////////////////////////////////////
		TextArea itemListArea = new TextArea();
		itemListArea.setBackground(new Color(51, 204, 51));
		itemListArea.setFont(new Font("Segoe UI", Font.BOLD, 13));
		itemListArea.setBounds(10, 11, 330, 281);
		merchCalc.add(itemListArea);

		ArrayList<String> names = SearchableItemSetup(items);
		StringSearchable search = new StringSearchable(names);
		AutocompleteJComboBox itemPicker = new AutocompleteJComboBox(search);
		itemPicker.setEditable(true);
		itemPicker.setBounds(456, 11, 137, 20);
		merchCalc.add(itemPicker);

		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.setBackground(new Color(0, 255, 102));

		ArrayList<String> userItems = new ArrayList<String>();

		btnAddItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					String itemSelected = (String) itemPicker.getSelectedItem();
					if(itemSelected!=null){
						userItems.add(itemSelected);
						itemListArea.append("\n"+itemSelected);
					}
					else{
						JOptionPane.showMessageDialog(null, "Please check your selection.");
					}
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, "Please check your selection.");
				}

			}
		});
		btnAddItem.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnAddItem.setBounds(357, 9, 89, 23);
		merchCalc.add(btnAddItem);
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.setBackground(new Color(0, 255, 102));
		btnUndo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					String undid = itemListArea.getText();
					undid = undid.substring(0, undid.lastIndexOf('\n'));
					itemListArea.setText(undid);
					userItems.remove(userItems.size()-1);
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, "Nothing to undo.");
				}
			}
		});
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnUndo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnUndo.setBounds(357, 76, 89, 23);
		merchCalc.add(btnUndo);

		JButton btnClearList = new JButton("Clear List");
		btnClearList.setBackground(new Color(0, 255, 102));
		btnClearList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					itemListArea.setText("");
					userItems.clear();
				}
				catch(Exception e1){
					
				}
			}
		});
		btnClearList.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnClearList.setBounds(357, 110, 89, 23);
		merchCalc.add(btnClearList);

		totalCoins = new JTextField();
		totalCoins.setBackground(new Color(102, 204, 102));
		totalCoins.setEditable(false);
		totalCoins.setBounds(437, 300, 137, 20);
		merchCalc.add(totalCoins);
		totalCoins.setColumns(10);

		JLabel lblTotalValue = new JLabel("Total Value:");
		lblTotalValue.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblTotalValue.setBounds(358, 299, 108, 20);
		merchCalc.add(lblTotalValue);

		Label showSellRateLabel = new Label("0");
		showSellRateLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		showSellRateLabel.setBounds(162, 298, 55, 22);
		merchCalc.add(showSellRateLabel);

		Label label_4 = new Label("Current Sell Rate % : ");
		label_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		label_4.setBounds(10, 298, 185, 22);
		merchCalc.add(label_4);

		sellPercent = new JTextField();
		sellPercent.setBounds(475, 196, 86, 20);
		merchCalc.add(sellPercent);
		sellPercent.setColumns(10);

		JLabel lblRateIn = new JLabel("Rate in %");
		lblRateIn.setBounds(475, 178, 97, 14);
		merchCalc.add(lblRateIn);
		
		JButton btnSetSellRate = new JButton("Set Sell Rate");
		btnSetSellRate.setBackground(new Color(0, 255, 102));
		btnSetSellRate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					if(sellPercent.getText()!=null){
						showSellRateLabel.setText(sellPercent.getText());
					}
				}
				catch(Exception e2){
					JOptionPane.showMessageDialog(null, "Please check your entry.");
				}
			}
		});
		btnSetSellRate.setBounds(357, 193, 108, 23);
		merchCalc.add(btnSetSellRate);

		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBackground(new Color(0, 255, 102));
		btnCalculate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					double percentage = Double.parseDouble(showSellRateLabel.getText());
					
					Long tot = computeMerch(percentage, items, userItems);
					String totalVal = tot.toString();
					totalCoins.setText(totalVal);
				}
				catch(Exception e3){
					JOptionPane.showMessageDialog(null, "Please check your entries.");
				}
			}
		});
		btnCalculate.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnCalculate.setBounds(357, 269, 89, 23);
		merchCalc.add(btnCalculate);

		/////////////////////////////////////////////////////////////////////////////


		JPanel dmgCalc = new JPanel();
		dmgCalc.setBackground(new Color(0, 153, 51));
		mainPane.addTab("Damage Calculator", null, dmgCalc, "Find out how much damage you can deal.");
		mainPane.setEnabledAt(3, true);
		dmgCalc.setLayout(null);

		attack = new JTextField();
		attack.setBounds(106, 38, 86, 20);
		dmgCalc.add(attack);
		attack.setColumns(10);

		weapon1min = new JTextField();
		weapon1min.setText("0");
		weapon1min.setBounds(10, 69, 86, 20);
		dmgCalc.add(weapon1min);
		weapon1min.setColumns(10);

		weapon1max = new JTextField();
		weapon1max.setText("0");
		weapon1max.setBounds(106, 69, 86, 20);
		dmgCalc.add(weapon1max);
		weapon1max.setColumns(10);

		weapon2min = new JTextField();
		weapon2min.setText("0");
		weapon2min.setBounds(10, 100, 86, 20);
		dmgCalc.add(weapon2min);
		weapon2min.setColumns(10);

		weapon2max = new JTextField();
		weapon2max.setText("0");
		weapon2max.setBounds(106, 100, 86, 20);
		dmgCalc.add(weapon2max);
		weapon2max.setColumns(10);

		enemyDef = new JTextField();
		enemyDef.setBounds(106, 131, 86, 20);
		dmgCalc.add(enemyDef);
		enemyDef.setColumns(10);

		percentCrit = new JTextField();
		percentCrit.setBounds(106, 162, 86, 20);
		dmgCalc.add(percentCrit);
		percentCrit.setColumns(10);

		critMult = new JTextField();
		critMult.setBounds(106, 193, 86, 20);
		dmgCalc.add(critMult);
		critMult.setColumns(10);

		JLabel lblAttackStat = new JLabel("Attack Stat (Strength for Warrior, magic for Mage etc.)");
		lblAttackStat.setBounds(202, 41, 310, 14);
		dmgCalc.add(lblAttackStat);

		JLabel lblWeaponMinmax = new JLabel("Weapon 1 Min/Max damage");
		lblWeaponMinmax.setBounds(202, 72, 174, 14);
		dmgCalc.add(lblWeaponMinmax);

		JLabel lblWeaponMinmax_1 = new JLabel("Weapon 2 Min/Max damage");
		lblWeaponMinmax_1.setBounds(202, 103, 161, 14);
		dmgCalc.add(lblWeaponMinmax_1);

		JLabel lblEnemyDefense = new JLabel("Enemy Defense");
		lblEnemyDefense.setBounds(202, 134, 103, 14);
		dmgCalc.add(lblEnemyDefense);

		JLabel lblPlayerCriticalHit = new JLabel("Player Critical Hit Chance (in percent)");
		lblPlayerCriticalHit.setBounds(202, 167, 214, 14);
		dmgCalc.add(lblPlayerCriticalHit);

		JLabel lblPlayerCriticalHit_1 = new JLabel("Player Critical Hit Bonus Damage (in percent)");
		lblPlayerCriticalHit_1.setBounds(202, 196, 265, 14);
		dmgCalc.add(lblPlayerCriticalHit_1);

		minResult = new JTextField();
		minResult.setBackground(new Color(102, 204, 102));
		minResult.setEditable(false);
		minResult.setBounds(32, 260, 86, 20);
		dmgCalc.add(minResult);
		minResult.setColumns(10);

		maxResult = new JTextField();
		maxResult.setBackground(new Color(102, 204, 102));
		maxResult.setEditable(false);
		maxResult.setEnabled(true);
		maxResult.setText("");
		maxResult.setBounds(150, 260, 86, 20);
		dmgCalc.add(maxResult);
		maxResult.setColumns(10);

		JLabel lblMinimumDamage = new JLabel("Minimum Damage");
		lblMinimumDamage.setBounds(32, 235, 103, 14);
		dmgCalc.add(lblMinimumDamage);

		JLabel lblMaximumDamage = new JLabel("Maximum Damage");
		lblMaximumDamage.setBounds(150, 235, 109, 14);
		dmgCalc.add(lblMaximumDamage);

		JButton btnSubmit_1 = new JButton("Submit");
		btnSubmit_1.setBackground(new Color(0, 255, 102));
		btnSubmit_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int attk, weaponmin1, weaponmax1, weaponmin2, weaponmax2, enemydef, critmult, critchnce;
				try{
					attk = Integer.parseInt(attack.getText());
					weaponmin1 = Integer.parseInt(weapon1min.getText());
					weaponmin2 = Integer.parseInt(weapon2min.getText());
					weaponmax1 = Integer.parseInt(weapon1max.getText());
					weaponmax2 = Integer.parseInt(weapon2max.getText());
					enemydef = Integer.parseInt(enemyDef.getText());
					critmult = Integer.parseInt(critMult.getText());
					critchnce = Integer.parseInt(percentCrit.getText());

					int [] res = DamageCalc(attk, weaponmin1, weaponmin2, weaponmax1, weaponmax2, enemydef, critmult, critchnce);
					int minRes = res[0];
					int maxRes = res[1];


					minResult.setText(Integer.toString(minRes));
					maxResult.setText(Integer.toString(maxRes));


				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Please enter a valid number.");
				}


			}
		});
		btnSubmit_1.setBounds(327, 259, 89, 23);
		dmgCalc.add(btnSubmit_1);

		JButton btnClear_1 = new JButton("Clear");
		btnClear_1.setBackground(new Color(0, 255, 102));
		btnClear_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				attack.setText(null);
				weapon1min.setText("0");
				weapon1max.setText("0");
				weapon2min.setText("0");
				weapon2max.setText("0");
				enemyDef.setText(null);
				percentCrit.setText(null);
				critMult.setText(null);
				minResult.setText(null);
				maxResult.setText(null);

			}
		});


		////////////////////////////////////////////////////////////////////


		btnClear_1.setBounds(423, 259, 89, 23);
		dmgCalc.add(btnClear_1);

		JPanel Itembylvl = new JPanel();
		Itembylvl.setBackground(new Color(0, 153, 51));
		mainPane.addTab("Items by Level", null, Itembylvl, null);
		mainPane.setEnabledAt(4, true);
		Itembylvl.setLayout(null);

		levelMin = new JTextField();
		levelMin.setBounds(40, 40, 86, 20);
		Itembylvl.add(levelMin);
		levelMin.setColumns(10);

		levelMax = new JTextField();
		levelMax.setBounds(192, 40, 86, 20);
		Itembylvl.add(levelMax);
		levelMax.setColumns(10);

		JLabel lblTo = new JLabel("To:");
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo.setBounds(158, 43, 46, 14);
		Itembylvl.add(lblTo);

		JLabel lblItemsInRange = new JLabel("Items in level range:");
		lblItemsInRange.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblItemsInRange.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemsInRange.setBounds(93, 15, 126, 14);
		Itembylvl.add(lblItemsInRange);

		JLabel lblFrom = new JLabel("From:");
		lblFrom.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrom.setBounds(0, 43, 46, 14);
		Itembylvl.add(lblFrom);

		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setBackground(new Color(51, 204, 51));
		textArea.setFont(new Font("Segoe UI", Font.BOLD, 13));
		textArea.setBounds(10, 66, 525, 230);
		Itembylvl.add(textArea);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(new Color(0, 255, 102));
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					textArea.setText("");
					if(Integer.parseInt(levelMin.getText())<=Integer.parseInt(levelMax.getText())){
						ArrayList<itemType> itemsInRange = getItemsByLevel(items,Integer.parseInt(levelMin.getText()),Integer.parseInt(levelMax.getText()));
						
						for(int i = 0; i < itemsInRange.size();i++){
							textArea.append(itemsInRange.get(i).name+"\n");
						}
					}
				}
				catch(Exception e4){
					JOptionPane.showMessageDialog(null, "Please check your entries.");
				}
			}
		});
		btnSubmit.setBounds(318, 39, 89, 23);
		Itembylvl.add(btnSubmit);

		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(new Color(0, 255, 102));
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					textArea.setText("");
				}
				catch(Exception e5){
					
				}
			}
		});
		btnClear.setBounds(417, 39, 89, 23);
		Itembylvl.add(btnClear);


		///////////////////////////////////////////////////////////////////////////////


		JPanel monsterDmgCalc = new JPanel();
		monsterDmgCalc.setBackground(new Color(0, 153, 51));
		mainPane.addTab("Monster Damage Calculator", null, monsterDmgCalc, "Find out how much damage you will take from a given monster.");
		monsterDmgCalc.setLayout(null);
		
		ArrayList<String> monster = SearchableMonsterSetup(monsters);
		StringSearchable searchMon = new StringSearchable(monster);
		AutocompleteJComboBox monsterBox = new AutocompleteJComboBox(searchMon);
		monsterBox.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		monsterBox.setEditable(true);
		monsterBox.setBounds(33, 74, 185, 20);
		monsterDmgCalc.add(monsterBox);
		
		playerDefense = new JTextField();
		playerDefense.setBounds(33, 143, 86, 20);
		monsterDmgCalc.add(playerDefense);
		playerDefense.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Select Monster:");
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(33, 49, 138, 20);
		monsterDmgCalc.add(lblNewLabel_6);
		
		JLabel lblEnterYourDefense = new JLabel("Enter your defense: ");
		lblEnterYourDefense.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblEnterYourDefense.setBounds(33, 118, 138, 20);
		monsterDmgCalc.add(lblEnterYourDefense);
		
		JLabel lblDamageYouTake = new JLabel("Damage you take:");
		lblDamageYouTake.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblDamageYouTake.setBounds(33, 198, 138, 20);
		monsterDmgCalc.add(lblDamageYouTake);
		
		damageTaken = new JTextField();
		damageTaken.setBackground(new Color(102, 204, 102));
		damageTaken.setEditable(false);
		damageTaken.setBounds(33, 230, 86, 20);
		monsterDmgCalc.add(damageTaken);
		damageTaken.setColumns(10);
		
		TextArea monsterInfo = new TextArea();
		monsterInfo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		monsterInfo.setBackground(new Color(51, 204, 51));
		monsterInfo.setBounds(331, 74, 240, 206);
		monsterDmgCalc.add(monsterInfo);
		
		Label label_5 = new Label("Additional Monster Info:");
		label_5.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		label_5.setBounds(331, 32, 248, 37);
		monsterDmgCalc.add(label_5);
		
		JButton btnMonCompute = new JButton("Compute");
		btnMonCompute.setBackground(new Color(0, 255, 102));
		btnMonCompute.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					int playerD = Integer.parseInt(playerDefense.getText());
					mob monster = monsterSelect(monsters, (String) monsterBox.getSelectedItem());
					
					String monInfo = "Name: "+ monster.name +"\nHealth: "+monster.health+"\nAttack: "+monster.attack+"\nDefense: "+monster.defense;
					monsterInfo.setText(monInfo);
					int mAttk = monster.attack;
					Double mTotalAttk = (mAttk*1.6)-playerD;
					damageTaken.setText(mTotalAttk.toString());
					
				}
				catch(Exception e4){
					JOptionPane.showMessageDialog(null, "Please check your entries.");
				}
			}
		});
		btnMonCompute.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnMonCompute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMonCompute.setBounds(204, 223, 89, 23);
		monsterDmgCalc.add(btnMonCompute);
		
		JButton btnMonClear = new JButton("Clear All");
		btnMonClear.setBackground(new Color(0, 255, 102));
		btnMonClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMonClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					damageTaken.setText("");
					monsterInfo.setText("");
					playerDefense.setText("");
				}
				catch(Exception e4){
					JOptionPane.showMessageDialog(null, "Please check your entries.");
				}
			}
		});
		btnMonClear.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnMonClear.setBounds(204, 257, 89, 23);
		monsterDmgCalc.add(btnMonClear);
		mainPane.setEnabledAt(5, true);


		//////////////////////////////////////////////////////////////////////////////


		JPanel statAlloc = new JPanel();
		statAlloc.setBackground(new Color(0, 153, 51));
		mainPane.addTab("Stat Allocation Guide", null, statAlloc, "Help you figure out what your optimal stats will look like.");
		mainPane.setEnabledAt(6, true);
		statAlloc.setLayout(null);

		JLabel lblEnterYourStats = new JLabel("Enter your stats as they appear on your character info screen.");
		lblEnterYourStats.setBounds(16, 32, 361, 23);
		statAlloc.add(lblEnterYourStats);

		hp = new JTextField();
		hp.setText("0");
		hp.setBounds(92, 58, 86, 20);
		statAlloc.add(hp);
		hp.setColumns(10);

		mp = new JTextField();
		mp.setText("0");
		mp.setBounds(92, 89, 86, 20);
		statAlloc.add(mp);
		mp.setColumns(10);

		dex = new JTextField();
		dex.setText("0");
		dex.setBounds(92, 120, 86, 20);
		statAlloc.add(dex);
		dex.setColumns(10);

		strength = new JTextField();
		strength.setText("0");
		strength.setBounds(92, 151, 86, 20);
		statAlloc.add(strength);
		strength.setColumns(10);

		range = new JTextField();
		range.setText("0");
		range.setBounds(92, 182, 86, 20);
		statAlloc.add(range);
		range.setColumns(10);

		magic = new JTextField();
		magic.setText("0");
		magic.setBounds(92, 213, 86, 20);
		statAlloc.add(magic);
		magic.setColumns(10);

		artillery = new JTextField();
		artillery.setText("0");
		artillery.setBounds(92, 244, 86, 20);
		statAlloc.add(artillery);
		artillery.setColumns(10);

		defense = new JTextField();
		defense.setText("0");
		defense.setBounds(92, 275, 86, 20);
		statAlloc.add(defense);
		defense.setColumns(10);

		strBonus = new JTextField();
		strBonus.setText("0");
		strBonus.setBounds(194, 151, 86, 20);
		statAlloc.add(strBonus);
		strBonus.setColumns(10);

		rangeBonus = new JTextField();
		rangeBonus.setText("0");
		rangeBonus.setBounds(194, 182, 86, 20);
		statAlloc.add(rangeBonus);
		rangeBonus.setColumns(10);

		magicBonus = new JTextField();
		magicBonus.setText("0");
		magicBonus.setBounds(194, 213, 86, 20);
		statAlloc.add(magicBonus);
		magicBonus.setColumns(10);

		artBonus = new JTextField();
		artBonus.setText("0");
		artBonus.setBounds(194, 244, 86, 20);
		statAlloc.add(artBonus);
		artBonus.setColumns(10);

		defBonus = new JTextField();
		defBonus.setText("0");
		defBonus.setBounds(194, 275, 86, 20);
		statAlloc.add(defBonus);
		defBonus.setColumns(10);

		JLabel lblGearpetBonusStats = new JLabel("Gear/Pet Bonus Stats");
		lblGearpetBonusStats.setBounds(188, 123, 128, 14);
		statAlloc.add(lblGearpetBonusStats);

		JLabel lblHp = new JLabel("HP");
		lblHp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHp.setBounds(36, 61, 46, 14);
		statAlloc.add(lblHp);

		JLabel lblMp = new JLabel("MP");
		lblMp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMp.setBounds(36, 92, 46, 14);
		statAlloc.add(lblMp);

		JLabel lblNewLabel = new JLabel("Dexterity");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(16, 123, 66, 14);
		statAlloc.add(lblNewLabel);

		JLabel lblStrength = new JLabel("Strength");
		lblStrength.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStrength.setBounds(36, 154, 46, 14);
		statAlloc.add(lblStrength);

		JLabel lblNewLabel_1 = new JLabel("Range");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(36, 185, 46, 14);
		statAlloc.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Magic");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(36, 216, 46, 14);
		statAlloc.add(lblNewLabel_2);

		JLabel lblArtillery = new JLabel("Artillery");
		lblArtillery.setHorizontalAlignment(SwingConstants.RIGHT);
		lblArtillery.setBounds(36, 247, 46, 14);
		statAlloc.add(lblArtillery);

		JLabel lblDefense = new JLabel("Defense");
		lblDefense.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDefense.setBounds(36, 278, 46, 14);
		statAlloc.add(lblDefense);

		JLabel lblIfRankingsAre = new JLabel("By Ranking:");
		lblIfRankingsAre.setBounds(346, 129, 146, 14);
		statAlloc.add(lblIfRankingsAre);

		playerLevel = new JTextField();
		playerLevel.setBounds(347, 151, 86, 20);
		statAlloc.add(playerLevel);
		playerLevel.setColumns(10);

		bookBonus = new JTextField();
		bookBonus.setBounds(347, 182, 86, 20);
		statAlloc.add(bookBonus);
		bookBonus.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Player Level");
		lblNewLabel_3.setBounds(443, 154, 109, 14);
		statAlloc.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Book Bonus");
		lblNewLabel_4.setBounds(443, 185, 91, 14);
		statAlloc.add(lblNewLabel_4);

		JLabel lblByTotalStat = new JLabel("By Total Stat Points:");
		lblByTotalStat.setBounds(347, 66, 118, 14);
		statAlloc.add(lblByTotalStat);

		totalStats = new JTextField();
		totalStats.setBounds(347, 89, 86, 20);
		statAlloc.add(totalStats);
		totalStats.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Stat Points");
		lblNewLabel_5.setBounds(443, 92, 91, 14);
		statAlloc.add(lblNewLabel_5);

		JComboBox<Object> classSelect = new JComboBox<Object>();
		classSelect.setBackground(new Color(51, 255, 102));
		classSelect.setModel(new DefaultComboBoxModel<Object>(new String[] {"Select Class", "Warrior", "Archer", "Mage", "Cowboy"}));
		classSelect.setBounds(466, 8, 99, 20);
		statAlloc.add(classSelect);

		JRadioButton rdbtnStatsMethod = new JRadioButton("Using this method");
		rdbtnStatsMethod.setBackground(new Color(0, 153, 51));
		rdbtnStatsMethod.setBounds(188, 7, 128, 23);
		statAlloc.add(rdbtnStatsMethod);

		JRadioButton rdbtnTotalMethod = new JRadioButton("Using this method");
		rdbtnTotalMethod.setBackground(new Color(0, 153, 51));
		rdbtnTotalMethod.setBounds(471, 62, 146, 23);
		statAlloc.add(rdbtnTotalMethod);

		JRadioButton rdbtnRankingMethod = new JRadioButton("Using this method");
		rdbtnRankingMethod.setBackground(new Color(0, 153, 51));
		rdbtnRankingMethod.setBounds(471, 125, 146, 23);
		statAlloc.add(rdbtnRankingMethod);

		ButtonGroup statAllocGroup = new ButtonGroup();
		statAllocGroup.add(rdbtnRankingMethod);
		statAllocGroup.add(rdbtnTotalMethod);
		statAllocGroup.add(rdbtnStatsMethod);


		JButton btnCompute = new JButton("Compute");
		btnCompute.setBackground(new Color(0, 255, 102));
		btnCompute.addMouseListener(new MouseAdapter() {
			@Override

			public void mouseClicked(MouseEvent arg0) {
				int TotalStats, HP, MP, Dexterity, Strength, Range, Magic, Artillery, 
				Defense, StrBonus, RangeBonus, MagicBonus, ArtilleryBonus, DefenseBonus, rankLevel, rankBookBonus;
				String classSelected;
				int[] calculatedStats; //HP, MP, Dexterity, Strength, Range, Magic, Artillery, Defense
				try{
					if(classSelect.getSelectedItem().equals("Select Class")){
						JOptionPane.showMessageDialog(null, "Please select a class.");
					}
					else{
						classSelected = (String)classSelect.getSelectedItem();

						if(rdbtnRankingMethod.isSelected()){
							rankLevel = Integer.parseInt(playerLevel.getText());
							rankBookBonus = Integer.parseInt(bookBonus.getText());

							TotalStats = ((rankLevel*3)+(rankBookBonus/10));

							calculatedStats = doStatAllocation(TotalStats, classSelected);

							if(classSelected == "Warrior"){
								strength.setText(Integer.toString(calculatedStats[0]));
								range.setText("0");
								magic.setText("0");
								artillery.setText("0");
							}
							else if(classSelected == "Mage"){
								strength.setText("0");
								range.setText("0");
								magic.setText(Integer.toString(calculatedStats[0]));
								artillery.setText("0");
							}
							else if(classSelected == "Archer"){
								strength.setText("0");
								magic.setText("0");
								range.setText(Integer.toString(calculatedStats[0]));
								artillery.setText("0");
							}
							else if(classSelected == "Cowboy"){
								strength.setText("0");
								range.setText("0");
								artillery.setText(Integer.toString(calculatedStats[0]));
								magic.setText("0");
							}
							defense.setText(Integer.toString(calculatedStats[1]));
							dex.setText(Integer.toString(calculatedStats[2]));
							hp.setText(Integer.toString(calculatedStats[3]));
							mp.setText(Integer.toString(calculatedStats[4]));
						}

						else if(rdbtnTotalMethod.isSelected()){
							TotalStats = Integer.parseInt(totalStats.getText());
							calculatedStats = doStatAllocation(TotalStats, classSelected);

							if(classSelected == "Warrior"){
								strength.setText(Integer.toString(calculatedStats[0]));
								range.setText("0");
								magic.setText("0");
								artillery.setText("0");
							}
							else if(classSelected == "Mage"){
								strength.setText("0");
								range.setText("0");
								magic.setText(Integer.toString(calculatedStats[0]));
								artillery.setText("0");
							}
							else if(classSelected == "Archer"){
								strength.setText("0");
								magic.setText("0");
								range.setText(Integer.toString(calculatedStats[0]));
								artillery.setText("0");
							}
							else if(classSelected == "Cowboy"){
								strength.setText("0");
								range.setText("0");
								artillery.setText(Integer.toString(calculatedStats[0]));
								magic.setText("0");
							}

							defense.setText(Integer.toString(calculatedStats[1]));
							dex.setText(Integer.toString(calculatedStats[2]));
							hp.setText(Integer.toString(calculatedStats[3]));
							mp.setText(Integer.toString(calculatedStats[4]));

						}

						else if(rdbtnStatsMethod.isSelected()){
							HP = Integer.parseInt(hp.getText())/10;
							MP = Integer.parseInt(mp.getText())/10;
							Dexterity = Integer.parseInt(dex.getText());
							Strength = Integer.parseInt(strength.getText());
							Range = Integer.parseInt(range.getText());
							Magic = Integer.parseInt(magic.getText());
							Artillery = Integer.parseInt(artillery.getText());
							Defense = Integer.parseInt(defense.getText());
							StrBonus = Integer.parseInt(strBonus.getText());
							RangeBonus = Integer.parseInt(rangeBonus.getText());
							MagicBonus = Integer.parseInt(magicBonus.getText());
							ArtilleryBonus = Integer.parseInt(artBonus.getText());
							DefenseBonus = Integer.parseInt(defBonus.getText());

							TotalStats = HP+MP+Dexterity+Strength+Range+Magic+Artillery+Defense-StrBonus-RangeBonus-MagicBonus-ArtilleryBonus-DefenseBonus;

							calculatedStats = doStatAllocation(TotalStats, classSelected);
							/*The calculatedStats array will return in the form:
							resultStats[0] = attack;
							resultStats[1] = defense;
							resultStats[2] = dexterity;
							resultStats[3] = health;
							resultStats[4] = mana;*/

							if(classSelected == "Warrior"){

								strength.setText(Integer.toString(calculatedStats[0]));
								range.setText("0");
								magic.setText("0");
								artillery.setText("0");
							}
							else if(classSelected == "Mage"){
								strength.setText("0");
								range.setText("0");
								magic.setText(Integer.toString(calculatedStats[0]));
								artillery.setText("0");
							}
							else if(classSelected == "Archer"){
								JOptionPane.showMessageDialog(null, "Archer Selected");
								strength.setText("0");
								magic.setText("0");
								range.setText(Integer.toString(calculatedStats[0]));
								artillery.setText("0");
							}
							else if(classSelected == "Cowboy"){
								strength.setText("0");
								range.setText("0");
								artillery.setText(Integer.toString(calculatedStats[0]));
								magic.setText("0");
							}
							defense.setText(Integer.toString(calculatedStats[1]));
							dex.setText(Integer.toString(calculatedStats[2]));
							hp.setText(Integer.toString(calculatedStats[3]));
							mp.setText(Integer.toString(calculatedStats[4]));
						}

						else{
							JOptionPane.showMessageDialog(null, "Please select a method.");
						}

					}
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Please enter a valid number.");
				}

			}
		});
		btnCompute.setBounds(347, 243, 89, 23);
		statAlloc.add(btnCompute);

		JButton btnClearAll = new JButton("Clear All");
		btnClearAll.setBackground(new Color(0, 255, 102));
		btnClearAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				strength.setText("0");
				range.setText("0");
				artillery.setText("0");
				magic.setText("0");
				defense.setText("0");
				dex.setText("0");
				hp.setText("0");
				mp.setText("0");
				bookBonus.setText("");
				playerLevel.setText("");
				totalStats.setText("");
				strBonus.setText("0");
				rangeBonus.setText("0");
				magicBonus.setText("0");
				artBonus.setText("0");
				defBonus.setText("0");
				classSelect.setSelectedIndex(0);
				statAllocGroup.clearSelection();

			}
		});
		btnClearAll.setBounds(463, 243, 89, 23);
		statAlloc.add(btnClearAll);


		////////////////////////////////////////////////////////////////////////////


		JPanel itemSearch = new JPanel();
		itemSearch.setBackground(new Color(0, 153, 51));
		mainPane.addTab("Item Search", null, itemSearch, null);
		itemSearch.setLayout(null);
		
		ArrayList<String> nameSearch = SearchableItemSetup(items);
		StringSearchable searchNames = new StringSearchable(nameSearch);
		AutocompleteJComboBox itemSearchBox = new AutocompleteJComboBox(searchNames);
		itemSearchBox.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		itemSearchBox.setEditable(true);
		itemSearchBox.setBounds(88, 41, 171, 20);
		itemSearch.add(itemSearchBox);
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblSearch.setBounds(41, 44, 76, 14);
		itemSearch.add(lblSearch);
		
		JLabel lblNameSearch = new JLabel("Name Search");
		lblNameSearch.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNameSearch.setBounds(10, 11, 107, 19);
		itemSearch.add(lblNameSearch);
		
		TextArea itemList = new TextArea();
		itemList.setFont(new Font("Segoe UI", Font.BOLD, 13));
		itemList.setBackground(new Color(51, 204, 51));
		itemList.setBounds(316, 41, 263, 261);
		itemSearch.add(itemList);
		
		JLabel lblPriceSearch = new JLabel("Price Search");
		lblPriceSearch.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblPriceSearch.setBounds(10, 109, 107, 20);
		itemSearch.add(lblPriceSearch);
		
		priceMin = new JTextField();
		priceMin.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		priceMin.setBounds(52, 140, 86, 20);
		itemSearch.add(priceMin);
		priceMin.setColumns(10);
		
		JLabel lblFrom_1 = new JLabel("From:");
		lblFrom_1.setBounds(20, 144, 46, 14);
		itemSearch.add(lblFrom_1);
		
		priceMax = new JTextField();
		priceMax.setBounds(173, 141, 86, 20);
		itemSearch.add(priceMax);
		priceMax.setColumns(10);
		
		JLabel lblTo_1 = new JLabel("To:");
		lblTo_1.setBounds(148, 144, 46, 14);
		itemSearch.add(lblTo_1);
		
		JLabel lblLocationSearch = new JLabel("Location Search");
		lblLocationSearch.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblLocationSearch.setBounds(10, 212, 107, 14);
		itemSearch.add(lblLocationSearch);
		
		JLabel lblItemInformationlist = new JLabel("Item Information/List:");
		lblItemInformationlist.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblItemInformationlist.setBounds(316, 14, 177, 21);
		itemSearch.add(lblItemInformationlist);
		
		JButton btnNSearch = new JButton("Search");
		btnNSearch.setBackground(new Color(0, 255, 102));
		btnNSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					//level, price, class, name, location
					
					String itemSelected = (String) itemSearchBox.getSelectedItem();
					ArrayList<String> userItem = new ArrayList<String>();
					userItem.add(itemSelected);
					ArrayList<itemType> foundItem = itemsGet(items, userItem);
					itemType itemObj = foundItem.get(0);
					itemList.setText("");
					String info = "Item Name: "+itemObj.name+"\n\nClass: "+itemObj.group+"\nPrice: "+itemObj.price+"\nLevel Requirement: "+itemObj.level+"\nLocation: "+itemObj.location;
					itemList.setText(info);
					
				}
				catch(Exception e4){
					JOptionPane.showMessageDialog(null, "Please verify your entry.");
				}
			}
		});
		btnNSearch.setBounds(51, 72, 89, 23);
		itemSearch.add(btnNSearch);
		
		JButton btnNSClear = new JButton("Clear");
		btnNSClear.setBackground(new Color(0, 255, 102));
		btnNSClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				itemList.setText("");
			}
		});
		btnNSClear.setBounds(170, 72, 89, 23);
		itemSearch.add(btnNSClear);
		
		JButton btnPSearch = new JButton("Search");
		btnPSearch.setBackground(new Color(0, 255, 102));
		btnPSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					int minPrice = Integer.parseInt(priceMin.getText());
					int maxPrice = Integer.parseInt(priceMax.getText());
					ArrayList<String> itemLocationList = itemsListFromPrice(items, minPrice,maxPrice);
					itemList.setText("");
					for(int i = 0; i < itemLocationList.size();i++){
						itemList.append(itemLocationList.get(i)+"\n");
					}
				}
				catch(Exception e4){
					JOptionPane.showMessageDialog(null, "Please verify your entries.");
				}
			}
		});
		btnPSearch.setEnabled(true);
		btnPSearch.setBounds(49, 171, 89, 23);
		itemSearch.add(btnPSearch);
		
		JButton btnPSClear = new JButton("Clear");
		btnPSClear.setBackground(new Color(0, 255, 102));
		btnPSClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				priceMin.setText("");
				priceMax.setText("");
				itemList.setText("");
			}
		});
		btnPSClear.setBounds(170, 171, 89, 23);
		itemSearch.add(btnPSClear);
		
		ArrayList<String> locationSearch = searchLocSetup(items);
		StringSearchable searchLocations = new StringSearchable(locationSearch);
		AutocompleteJComboBox comboBox = new AutocompleteJComboBox(searchLocations);
		comboBox.setBounds(88, 237, 171, 20);
		itemSearch.add(comboBox);
		
		JLabel lblSearch_1 = new JLabel("Search:");
		lblSearch_1.setBounds(41, 240, 76, 14);
		itemSearch.add(lblSearch_1);
		
		JButton btnLSearch = new JButton("Search");
		btnLSearch.setBackground(new Color(0, 255, 102));
		btnLSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					String location = (String) comboBox.getSelectedItem();
					ArrayList<String>itemsFromLocation = locationInventory(items, location);
					itemList.setText("");
					for(int i = 0; i<itemsFromLocation.size();i++){
						itemList.append(itemsFromLocation.get(i)+"\n");
					}
					
				}
				catch(Exception e4){
					JOptionPane.showMessageDialog(null, "Please verify your entries.");
				}
			}
		});
		btnLSearch.setBounds(49, 279, 89, 23);
		itemSearch.add(btnLSearch);
		
		JButton btnLSClear = new JButton("Clear");
		btnLSClear.setBackground(new Color(0, 255, 102));
		btnLSClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				itemList.setText("");
			}
		});
		btnLSClear.setBounds(170, 279, 89, 23);
		itemSearch.add(btnLSClear);
		mainPane.setEnabledAt(7, true);
		
		JPanel petDamageCalc = new JPanel();
		petDamageCalc.setBackground(new Color(0, 153, 51));
		mainPane.addTab("Pet Damage Calculator", null, petDamageCalc, null);
		petDamageCalc.setLayout(null);
		
		JLabel lblPetAttackStat = new JLabel("Pet  Attack Stat:");
		lblPetAttackStat.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPetAttackStat.setBounds(-41, 11, 131, 14);
		petDamageCalc.add(lblPetAttackStat);
		
		JLabel lblPetDexterity = new JLabel("Pet Dexterity:");
		lblPetDexterity.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPetDexterity.setBounds(-41, 36, 131, 14);
		petDamageCalc.add(lblPetDexterity);
		
		JLabel lblNewLabel_7 = new JLabel("Attack Stance:");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_7.setBounds(-31, 61, 121, 14);
		petDamageCalc.add(lblNewLabel_7);
		
		petAttk = new JTextField();
		petAttk.setBounds(100, 8, 86, 20);
		petDamageCalc.add(petAttk);
		petAttk.setColumns(10);
		
		petDex = new JTextField();
		petDex.setBounds(100, 33, 86, 20);
		petDamageCalc.add(petDex);
		petDex.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(100, 58, 86, 20);
		petDamageCalc.add(comboBox_1);
		
		JLabel lblNewLabel_8 = new JLabel("Monster:");
		lblNewLabel_8.setBounds(272, 11, 46, 14);
		petDamageCalc.add(lblNewLabel_8);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(328, 8, 95, 20);
		petDamageCalc.add(comboBox_2);
		
		TextArea textArea_2 = new TextArea();
		textArea_2.setBackground(new Color(0, 204, 0));
		textArea_2.setBounds(241, 36, 290, 160);
		petDamageCalc.add(textArea_2);
	}


	////////////////////////////////////////////////////////////////////////////////////


	static long lvlCalc(int num1, int num2, int num3){

		long givenum = 0, mult1, mult2, add1, sqrd, fin = 0;
		for(int i = num1; i < num2; ++i){//This follows the algorithm used to calculate the experience needed to get
			mult1 = 50 * i;			     //the next level then adds it up to the total level and it's corresponding exp.
			sqrd = i * i;
			mult2 = (long) ((long)sqrd * 1.1);
			add1 = mult1 + mult2;
			fin = fin + add1;
			givenum = fin - num3;
		}
		return givenum;
	}

	static int[] DamageCalc(int attk, int weaponmin1, int weaponmin2, int weaponmax1, int weaponmax2, int enemydef, int critmult, int critchnce){
		int [] results = {0,0};

		double critmulty=critmult/100;
		int mindmg=(int)((attk*(weaponmin1+weaponmin2))/enemydef);
		double maxdmg=(attk*(weaponmax1+weaponmax2))/enemydef;
		int dexmax=(int)((maxdmg)*critmulty);

		results[0] = mindmg;
		results[1] = dexmax;

		return results;
	}

	static int[] doStatAllocation(int totalStatPoints, String classSelected){
		int tsp = totalStatPoints;
		String SACl = classSelected;
		int pofsa = 0, pofsdf = 0, pofsdx=0, pofsh=0, pofsmp=0, hpofsa=0, hpofsdf=0, hpofsmp=0;//percentage of stats to attack, defense, dexterity, health and mp Then "high" versions of previous.
		double alla, alldf, alldx, allh, allmp;
		char trig = 'l';
		int [] resultStats = {0,0,0,0,0,0};
		if(SACl == "Warrior"){
			if(tsp<300&&tsp>3){
				pofsa = 45;
				pofsdf = 40;
				pofsdx = 10;
				pofsh = 0;
				pofsmp = 5;

				trig = 'l';
			}
			else if(tsp<600&&tsp>300){
				pofsa = 50;
				pofsdf = 30;
				pofsdx = 15;
				pofsh = 0;
				pofsmp = 5;

				trig = 'l';
			}
			else if(tsp<1000&&tsp>600){
				pofsa = 40;
				pofsdf = 30;
				pofsdx = 25;
				pofsh = 0;
				pofsmp = 5;

				trig = 'l';
			}
			else if(tsp<=3000&&tsp>1000){
				hpofsa = 60;
				hpofsdf = 35;
				hpofsmp = 5;

				trig = 'h';
			}
			else if(tsp<=6000&&tsp>3000){
				hpofsa = 65;
				hpofsdf = 30;
				hpofsmp = 5;

				trig = 'h';
			}
			else if(tsp>6000&&tsp<=15000){
				hpofsa = 75;
				hpofsdf = 20;
				hpofsmp = 5;

				trig = 'h';
			}
			else if(tsp<=25000&&tsp>15000){
				hpofsa = 73;
				hpofsdf = 25;
				hpofsmp = 2;
				trig = 'h';
			}
			else if(tsp>25000&&tsp<=50000){
				hpofsa = 70;
				hpofsdf = 25;
				hpofsmp = 3;

				trig = 'h';
			}
			else if(tsp<=100000&&tsp>50000){
				hpofsa = 75;
				hpofsdf = 20;
				hpofsmp = 3;

				trig = 'h';
			}
			else if(tsp<=250000&&tsp>100000){
				hpofsa = 78;
				hpofsdf = 15;
				hpofsmp = 5;

				trig = 'h';
			}
			else if(tsp>250000){
				hpofsa = 80;
				hpofsdf = 10;
				hpofsmp = 5;

				trig = 'h';
			}

			if(trig=='l'){
				alla = (tsp*pofsa)/100;
				alldf = (tsp*pofsdf)/100;
				alldx = (tsp*pofsdx)/100;
				allh = (tsp*pofsh)/100;
				allmp = (tsp*pofsmp)/100;
			}
			else{
				tsp = tsp - 400;
				alla = (tsp*hpofsa)/100;
				alldf = (tsp*hpofsdf)/100;
				alldx = 300;
				allh = (tsp*pofsh)/100;;
				allmp = 50+((tsp*pofsmp)/100);
			}

			resultStats[0] = (int)alla;
			resultStats[1] = (int)alldf;
			resultStats[2] = (int)alldx;
			resultStats[3] = (int)allh;
			resultStats[4] = (int)allmp;
			//		for(int i = 0; i < 5; i++){
			//			System.out.println(resultStats[i]);
			//		}

		}
		else if(SACl == "Mage"){
			if(tsp<300&&tsp>3){
				pofsa = 60;
				pofsdf = 20;
				pofsdx = 10;
				pofsh = 0;
				pofsmp = 10;

				trig = 'l';
			}
			else if(tsp<600&&tsp>300){
				pofsa = 50;
				pofsdf = 20;
				pofsdx = 10;
				pofsh = 0;
				pofsmp = 20;

				trig = 'l';
			}
			else if(tsp<1000&&tsp>600){
				pofsa = 40;
				pofsdf = 20;
				pofsdx = 30;
				pofsh = 0;
				pofsmp = 10;

				trig = 'l';
			}
			else if(tsp<3000&&tsp>1000){
				hpofsa = 60;
				hpofsdf = 25;
				hpofsmp = 15;

				trig = 'h';
			}
			else if(tsp<6000&&tsp>3000){
				hpofsa = 60;
				hpofsdf = 20;
				hpofsmp = 20;

				trig = 'h';
			}
			else if(tsp>6000&&tsp<=15000){
				hpofsa = 60;
				hpofsdf = 20;
				hpofsmp = 20;

				trig = 'h';
			}
			else if(tsp<=25000&&tsp>15000){
				hpofsa = 73;
				hpofsdf = 20;
				hpofsmp = 7;

				trig = 'h';
			}
			else if(tsp>25000&&tsp<=50000){
				hpofsa = 70;
				hpofsdf = 20;
				hpofsmp = 9;

				trig = 'h';
			}
			else if(tsp<=100000&&tsp>50000){
				hpofsa = 74;
				hpofsdf = 20;
				hpofsmp = 5;

				trig = 'h';
			}
			else if(tsp<=250000&&tsp>100000){
				hpofsa = 78;
				hpofsdf = 15;
				hpofsmp = 5;

				trig = 'h';
			}
			else if(tsp>250000){
				hpofsa = 80;
				hpofsdf = 10;
				hpofsmp = 5;

				trig = 'h';
			}

			if(trig=='l'){
				alla = (tsp*pofsa)/100;
				alldf = (tsp*pofsdf)/100;
				alldx = (tsp*pofsdx)/100;
				allh = (tsp*pofsh)/100;
				allmp = (tsp*pofsmp)/100;
			}
			else{
				tsp = tsp - 430;
				alla = (tsp*hpofsa)/100;
				alldf = (tsp*hpofsdf)/100;
				alldx = 300;
				allh = 80+((tsp*pofsh)/100);
				allmp = (tsp*hpofsmp)/100;
			}

			resultStats[0] = (int)alla;
			resultStats[1] = (int)alldf;
			resultStats[2] = (int)alldx;
			resultStats[3] = (int)allh;
			resultStats[4] = (int)allmp;

		}
		else if(SACl == "Archer"){
			if(tsp<300&&tsp>3){
				pofsa = 70;
				pofsdf = 15;
				pofsdx = 10;
				pofsh = 0;
				pofsmp = 5;

				trig = 'l';
			}
			else if(tsp<600&&tsp>300){
				pofsa = 70;
				pofsdf = 10;
				pofsdx = 10;
				pofsh = 0;
				pofsmp = 10;

				trig = 'l';
			}
			else if(tsp<1000&&tsp>600){
				pofsa = 70;
				pofsdf = 15;
				pofsdx = 10;
				pofsh = 0;
				pofsmp = 5;

				trig = 'l';
			}
			else if(tsp<3000&&tsp>1000){
				hpofsa = 70;
				hpofsdf = 20;
				hpofsmp = 10;

				trig = 'h';
			}
			else if(tsp<6000&&tsp>3000){
				hpofsa = 80;
				hpofsdf = 10;
				hpofsmp = 10;

				trig = 'h';
			}
			else if(tsp>6000&&tsp<=15000){
				hpofsa = 65;
				hpofsdf = 15;
				hpofsmp = 20;

				trig = 'h';
			}
			else if(tsp<=25000&&tsp>15000){
				hpofsa = 75;
				hpofsdf = 15;
				hpofsmp = 10;

				trig = 'h';
			}
			else if(tsp>25000&&tsp<=50000){
				hpofsa = 75;
				hpofsdf = 15;
				hpofsmp = 9;

				trig = 'h';
			}
			else if(tsp<=100000&&tsp>50000){
				hpofsa = 74;
				hpofsdf = 15;
				hpofsmp = 10;

				trig = 'h';
			}
			else if(tsp<=250000&&tsp>100000){
				hpofsa = 78;
				hpofsdf = 15;
				hpofsmp = 5;

				trig = 'h';
			}
			else if(tsp>250000){
				hpofsa = 80;
				hpofsdf = 10;
				hpofsmp = 5;

				trig = 'h';
			}

			if(trig=='l'){
				alla = (tsp*pofsa)/100;
				alldf = (tsp*pofsdf)/100;
				alldx = (tsp*pofsdx)/100;
				allh = (tsp*pofsh)/100;
				allmp = (tsp*pofsmp)/100;
			}
			else{
				tsp = tsp - 430;
				alla = (tsp*hpofsa)/100;
				alldf = (tsp*hpofsdf)/100;
				alldx = 300;
				allh = 80+((tsp*pofsh)/100);
				allmp = (tsp*hpofsmp)/100;
			}

			resultStats[0] = (int)alla;
			resultStats[1] = (int)alldf;
			resultStats[2] = (int)alldx;
			resultStats[3] = (int)allh;
			resultStats[4] = (int)allmp;

		}
		else if(SACl == "Cowboy"){
			if(tsp<300&&tsp>3){
				pofsa = 53;
				pofsdf = 40;
				pofsdx = 10;
				pofsh = 0;
				pofsmp = 2;

				trig = 'l';
			}
			else if(tsp<600&&tsp>300){
				pofsa = 60;
				pofsdf = 20;
				pofsdx = 15;
				pofsh = 0;
				pofsmp = 5;

				trig = 'l';
			}
			else if(tsp<1000&&tsp>600){
				pofsa = 60;
				pofsdf = 15;
				pofsdx = 20;
				pofsh = 0;
				pofsmp = 5;

				trig = 'l';
			}
			else if(tsp<3000&&tsp>1000){
				hpofsa = 60;
				hpofsdf = 30;
				hpofsmp = 10;

				trig = 'h';
			}
			else if(tsp<6000&&tsp>3000){
				hpofsa = 70;
				hpofsdf = 20;
				hpofsmp = 10;

				trig = 'h';
			}
			else if(tsp>6000&&tsp<=15000){
				hpofsa = 70;
				hpofsdf = 15;
				hpofsmp = 15;

				trig = 'h';
			}
			else if(tsp<=25000&&tsp>15000){
				hpofsa = 73;
				hpofsdf = 15;
				hpofsmp = 10;

				trig = 'h';
			}
			else if(tsp>25000&&tsp<=50000){
				hpofsa = 70;
				hpofsdf = 20;
				hpofsmp = 9;

				trig = 'h';
			}
			else if(tsp<=100000&&tsp>50000){
				hpofsa = 74;
				hpofsdf = 20;
				hpofsmp = 5;

				trig = 'h';
			}
			else if(tsp<=250000&&tsp>100000){
				hpofsa = 78;
				hpofsdf = 15;
				hpofsmp = 5;

				trig = 'h';
			}
			else if(tsp>250000){
				hpofsa = 80;
				hpofsdf = 10;
				hpofsmp = 5;

				trig = 'h';
			}

			if(trig=='l'){
				alla = (tsp*pofsa)/100;
				alldf = (tsp*pofsdf)/100;
				alldx = (tsp*pofsdx)/100;
				allh = (tsp*pofsh)/100;
				allmp = (tsp*pofsmp)/100;
			}
			else{
				tsp = tsp - 430;
				alla = (tsp*hpofsa)/100;
				alldf = (tsp*hpofsdf)/100;
				alldx = 300;
				allh = ((tsp*pofsh)/100)+80;
				allmp = (tsp*hpofsmp)/100;
			}

			resultStats[0] = (int)alla;
			resultStats[1] = (int)alldf;
			resultStats[2] = (int)alldx;
			resultStats[3] = (int)allh;
			resultStats[4] = (int)allmp;

		}

		return resultStats;

	}


	///////////////////////////////////////////////////////////////////////////////
	
	static ArrayList<String> SearchableMonsterSetup(mob[] mobSet){
		ArrayList<String> monsterNames = new ArrayList<String>();
		for(int i = 0; i< mobSet.length;i++){
			monsterNames.add(mobSet[i].name);
		}
		return monsterNames;
	}
	static mob monsterSelect(mob[] mobSet, String monsterName){
		mob tempMon = null;
		for(int i = 0; i < mobSet.length;i++){
			if(mobSet[i].name.equals(monsterName)){
				tempMon = mobSet[i];
				break;
			}
		}
		return tempMon;
	}
	
	static ArrayList<String> searchLocSetup(itemType[] itemSet){
		Set<String> locations = new HashSet<String>();
		
		for(int i = 0; i< itemSet.length;i++){
			locations.add(itemSet[i].location);
		}
		ArrayList<String> locList = new ArrayList<String>();
		locList.addAll(locations);
		
		return locList;
	}

	static ArrayList<String> SearchableItemSetup(itemType[] itemSet){
		ArrayList<String> nameSet = new ArrayList<String>();
		
		for(int i = 0; i<itemSet.length;i++){
			nameSet.add(itemSet[i].name);
			
		}
		return nameSet;
	}

	static ArrayList<itemType> itemsGet(itemType[] itemSearchSet, ArrayList<String> itemName){
		ArrayList<itemType> foundItem = new ArrayList<itemType>();

		for(int j = 0; j < itemName.size();j++){

			for(int i = 0; i < itemSearchSet.length; i++){

				if(itemSearchSet[i].name == itemName.get(j)){

					foundItem.add(itemSearchSet[i]);
					break;

				}
			}
		}
		return foundItem;
	}
	
	static long computeMerch(double percentRate, itemType[] items, ArrayList<String> userItems){
		long total = 0;
		Double percent = percentRate/100;
		for(int i = 0; i < userItems.size(); i++){
			for(int j = 0; j < items.length;j++){
				if(userItems.get(i).equals(items[j].name)){
					total = total + (long)(items[j].price*percent);
					break;
				}
			}
		}
		return total;
	}
	
	static ArrayList<itemType> getItemsByLevel(itemType[] items, int startLevel, int endLevel){
		ArrayList<itemType> itemSet = new ArrayList<itemType>();
		for(int i = 0; i < items.length;i++){
			if(items[i].level>=startLevel&&items[i].level<=endLevel){
				itemSet.add(items[i]);
			}
		}
		return itemSet;
	}
	
	static ArrayList<String> itemsListFromPrice(itemType[] itemSet, int min, int max){
		ArrayList<String> itemList = new ArrayList<String>();
		for(int i = 0; i < itemSet.length;i++){
			if(itemSet[i].price>= min&&itemSet[i].price<=max){
				itemList.add(itemSet[i].name);
			}
		}
		return itemList;
	}
	
	static ArrayList<String> locationInventory(itemType[] itemSet, String location){
		ArrayList<String> locationItems = new ArrayList<String>();
		for(int i = 0; i < itemSet.length;i++){
			if(itemSet[i].location.equals(location)){
				locationItems.add(itemSet[i].name);
			}
		}
		return locationItems;
	}
}


























