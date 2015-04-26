//============================================================================
// Name        : HelmetHeroesLvCalculator.cpp
// Author      : Caleb Heidenreich
// Version     : 1.9
// Copyright   : THIS IS A FREE DISTRIBUTION TO ALL.
// Description : Helmet Heroes Assistant
//============================================================================
#include <iostream>
#include <string>
#include <sstream>
#include "ExitException.h"

using namespace std;
struct pet{
	int pp, ph, pdf, pdx, pc;
	string tp, ab1, ab2, ab3;
	pet(){}
	pet(int ppower, int phealth, int pdefense, int pdexterity, int pcost, string type, string ability1, string ability2, string ability3): pp(ppower), ph(phealth), pdf(pdefense), pdx(pdexterity), pc(pcost), tp(type), ab1(ability1), ab2(ability2), ab3(ability3){}
};
struct mob{
	int a, d, h;
	string nm, cn;
	mob(){}
	mob(int attack, int defense, int health, string name, string capName): a(attack), d(defense), h(health), nm(name), cn(capName){}
};
struct item{
	int lv;
	long long p, c;
	string n, l;
	item(){}
	item(int level, int price, int clss, string name, string loc): lv(level), p(price), c(clss), n(name), l(loc){}
};
int menu=0, pMenu=0;
template<typename T>
void Get(T &a){
	int count = 0;
	while(1){
		string s;
		getline(cin,s);
		if(s=="/end"){
			throw ExitException();
		}
		istringstream iss(s);
		iss>>a;

		if(!iss.fail())
			return;
		else{
			if(count>0){
				iss.clear();
				iss.ignore();
				cout<<"\nERROR: Number Expected.\n ==>";
				iss>>s;
			}
		}
		count++;
	}
}
void Get(string &s){
	int count=0;
	while(1){
		string s;
		getline(cin,s);
		if(s=="/end"){
			throw ExitException();
		}
		istringstream iss(s);
		iss>>s;
		if(!iss.fail())
			return;
		else{
			if(count>0){
				iss.clear();
				iss.ignore();
				cout<<"\nERROR: Number Expected.\n ==>";
				iss>>s;
			}
		}
		count++;
	}
}

//static int FailCheck(int checkee){
//	cin>>checkee;
//	while(cin.fail()==true){
//	cout<<"\n\nI am sorry but you need to enter a number.\nPlease try again: ";
//	cin.clear();
//	cin.ignore();
//	cin>>checkee;
//	}
//	return checkee;
//}

int maxItems = 565; //total number of items in the search-able catalog.
int main() {
	//Monster Catalog
	mob monster[36];//attack, defense, health, then name for compare and name for print
	monster[0]=mob(5, 2, 18,"green bouncer","Green Bouncer");
	monster[1]=mob(16, 8, 63,"green walker","Green Walker");
	monster[2]=mob(14, 6, 36,"purple goo","Purple Goo");
	monster[3]=mob(31, 18, 80,"red bouncer","Red Bouncer");
	monster[4]=mob(10, 6, 28,"mushroom squish","Mushroom Squish");
	monster[29]=mob(44, 36, 130, "mushroom ball","Mushroom Ball");
	monster[5]=mob(90, 88, 600,"bouncing mushroom","Bouncing Mushroom");
	monster[6]=mob(46, 46, 210,"orange crazy","Orange Crazy");
	monster[7]=mob(11, 8, 55,"yellow hairy monster","Yellow Hairy Monster");
	monster[8]=mob(130, 104, 670,"yellow puff monster","Yellow Puff Monster");
	monster[9]=mob(50, 52, 240,"horned monster","Horned Monster");
	monster[10]=mob(55, 56, 280,"crab","Crab");
	monster[11]=mob(153, 110, 800,"plant monster","Plant Monster");
	monster[12]=mob(74, 92, 750,"pumpkin creeper","Pumpkin Creeper");
	monster[13]=mob(220, 140, 1800,"great frog","Great Frog");
	monster[14]=mob(122, 120, 580,"penguin","Penguin");
	monster[15]=mob(278, 160, 4200,"sasquatch","Sasquatch");
	monster[16]=mob(95, 104, 12000,"goo cube","Goo Cube");
	monster[17]=mob(330, 230, 7000,"brick monster","Brick Monster");
	monster[18]=mob(192, 185, 1600,"block bot","Block Bot");
	monster[19]=mob(227, 180, 2700,"night stalker","Night Stalker");
	monster[20]=mob(365, 240, 6400,"drill bot","Drill Bot");
	monster[21]=mob(550, 250, 16000,"lotus eye","Lotus Eye");
	monster[22]=mob(720, 280, 24000,"dark beholder","Dark Beholder");
	monster[23]=mob(772, 200, 131000,"carnelia","Carnelia");
	monster[24]=mob(185, 170, 1500,"leafling","Leafling");
	monster[25]=mob(9, 9, 34,"leaflet","Leaflet");
	monster[26]=mob(475, 246, 10000,"glord","Glord");
	monster[27]=mob(690, 340, 30000,"kreeton","Kreeton");
	monster[28]=mob(180, 100, 210000,"giant goo cube","Giant Goo Cube");
	monster[29]=mob(1400, 380, 155000, "repguana", "Repguana");
	monster[30]=mob(1900, 360, 4000000, "kreetus", "Kreetus");
	monster[31]=mob(44, 66, 205, "fishum", "Fishum");
	monster[32]=mob(2200, 460, 270000, "proteum", "Proteum");
	monster[33]= mob(255, 175, 2000, "bionic bird", "Bionic Bird");
	monster[34]= mob(2800, 640, 350000, "titanium vulture", "Titanium Vulture");
	monster[35]= mob(4000, 850, 500000, "magmagon", "Magmagon");


	//item Catalog
	item items[maxItems]; //(level, price, class, name, location) class, 0=special 1=warrior 2=mage 3=archer 4=gunslinger
	items[0]=item(0,0,0,"null","null");
	items[1]=item( 105,318000, 3,"achilles armor" , "travis");
	items[2]=item( 60,40000, 3,"achilles boot" , "sam");
	items[3]=item( 104,345000, 3,"achilles helmet" , "travis");
	items[4]=item( 100,290000, 3,"achilles legs" , "travis");
	items[5]=item( 47,30000, 1,"adamantium armor" , "wallace");
	items[6]=item( 50,45000, 1,"adamantium helmet" , "wallace");
	items[7]=item( 43,24000, 1,"adamantium legs" , "wallace");
	items[8]=item( 93,320000, 3,"alloy wolf helmet" , "tiberius");
	items[9]=item( 60,75000, 1,"ancient armor" , "chance");
	items[10]=item( 59,55000, 1,"ancient battle axe" , "wallace");
	items[11]=item( 70,135000, 1,"ancient helmet" , "chance");
	items[12]=item( 56,65000, 1,"ancient legs" , "chance");
	items[13]=item( 61,82000, 1,"ancient shield" , "shane");
	items[14]=item( 26,15000, 3,"angel wings bow" , "snoop");
	items[15]=item( 19,9000, 3,"apollos armor" , "tiberius");
	items[16]=item( 18,6000, 3,"apollos armor legs" , "tiberius");
	items[17]=item( 24,15000, 3,"apollos helmet" , "tiberius");
	items[18]=item( 0,50, 0,"apple" , "geraldo");
	items[19]=item( 115,380000, 3,"archaic armor" , "anoop");
	items[20]=item( 72,60000, 3,"archaic boot" , "sam");
	items[21]=item( 110,360000, 3,"archaic bow" , "anoop");
	items[22]=item( 112,412000, 3,"archaic helmet" , "anoop");
	items[23]=item( 113,356000, 3,"archaic legs" , "anoop");
	items[24]=item( 5,1600, 3,"archer hat" , "heath");
	items[25]=item( 10,3200, 3, "archer leather legs", "alpipa");
	items[26]=item( 5,1600, 2,"archer pants" , "carter");
	items[27]=item( 15,3500, 3,"archer patches hat" , "snoop");
	items[28]=item( 5,1700, 3,"archer shirt" , "carter");
	items[29]=item( 74,147000, 1,"armor of hatred" , "sneed");
	items[30]=item( 18,6500, 1,"army helmet" , "alpipa");
	items[31]=item( 68,125000, 3,"assault armor" , "viper");
	items[32]=item( 45,24000, 3,"assault boots" , "sam");
	items[33]=item( 74,173000, 3,"assault helmet" , "viper");
	items[34]=item( 67,111000, 3,"assault legs" , "viper");
	items[35]=item( 96,290000, 2,"astro helmet" , "viper");
	items[36]=item( 78,160000, 2,"astro legs" , "viper");
	items[37]=item( 84,170000, 2,"astro suit" , "viper");
	items[38]=item( 65,82000, 1,"axe of minions" , "wallace");
	items[39]=item( 12,5400, 2,"ballerina outfit" , "rita");
	items[40]=item( 1,320, 2,"ballerina stockings" , "rita");
	items[41]=item( 0,35, 0,"banana" , "geraldo");
	items[42]=item( 85,161000, 1,"barbarian axe of fire" , "wallace");
	items[43]=item( 6,2500, 2,"basic magic staff" , "anoop");
	items[44]=item( 2,300, 2,"basic wand" , "anoop");
	items[45]=item( 40,45000, 2,"bat wing staff" , "chance");
	items[46]=item( 122,457000, 1,"beholder armor" , "chance");
	items[47]=item( 126,450000, 1,"beholder axe" , "wallace");
	items[48]=item( 74,90000, 1,"beholder boot" , "sam");
	items[49]=item( 101,280000, 1,"beholder bow" , "wallace");
	items[50]=item( 130,590000, 1,"beholder helmet" , "chance");
	items[51]=item( 116,358000, 1,"beholder legs" , "chance");
	items[52]=item( 113,290000, 1,"beholder shield" , "shane");
	items[53]=item( 89,210000, 1,"beholder staff" , "wallace");
	items[54]=item( 125,270000, 1,"beholder sword" , "wallace");
	items[55]=item( 84,175000, 1,"beholder wand" , "wallace");
	items[56]=item( 1,105, 1,"big stick" , "");
	items[57]=item( 90,220000, 1,"blade of hatred" , "sneed");
	items[58]=item( 2,140, 2,"blue beanie" , "heath");
	items[59]=item( 63,78000, 2,"blue crystal armor" , "viper");
	items[60]=item( 40,16000, 2,"blue crystal boot" , "sam");
	items[61]=item( 77,161000, 2,"blue crystal helmet" , "viper");
	items[62]=item( 59,72300, 2,"blue crystal legs" , "viper");
	items[63]=item( 23,8200, 1,"blue face helmet" , "alpipa");
	items[64]=item( 4,530, 2,"blue jeans" , "heath");
	items[65]=item( 7,1200, 2,"blue magic shoe" , "sam");
	items[66]=item( 2,170, 1,"blue plastic sword" , "heath");
	items[67]=item( 3,329, 2,"blue shirt" , "");
	items[68]=item( 13,5800, 2,"blue sphere staff" , "alpipa");
	items[69]=item( 13,4000, 2,"blue wizard pants" , "tiberius");
	items[70]=item( 34,11000, 2,"blue wizard belt hat" , "anoop");
	items[71]=item( 30,8000, 2,"blue wizard hat" , "anoop");
	items[72]=item( 16,6000, 2,"blue wizard robe" , "tiberius");
	items[73]=item( 4,600, 3,"body wrap" , "");
	items[74]=item( 4,650, 1,"bone" , "");
	items[75]=item( 4,470, 1,"bronze dagger" , "heath");
	items[76]=item( 23,8000, 1,"bronze plate armor" , "snoop");
	items[341]=item( 22,6800, 1, "bronze plate legs", "snoop");
	items[77]=item( 17,6200, 1,"bronze shield" , "shane");
	items[78]=item( 1,110, 1,"brown shoes" , "heath");
	items[79]=item( 5,1700, 2,"brown wizard pants" , "anoop");
	items[80]=item( 5,1800, 2,"brown wizard robe" , "anoop");
	items[81]=item( 15,4200, 1,"bucket helmet" , "");
	items[82]=item( 58,63000, 1,"captains rapier" , "wallace");
	items[83]=item( 25,6000, 3,"cat hat" , "rita");
	items[84]=item( 64,95000, 1,"chain armor" , "chance");
	items[85]=item( 74,160000, 1,"chain helmet" , "chance");
	items[86]=item( 61,82000, 1,"chain legs" , "chance");
	items[87]=item( 15,5000, 1,"chainmail" , "alpipa");
	items[88]=item( 15,4500, 1,"chainmail legs" , "alpipa");
	items[89]=item( 38,15000, 2,"charm hat" , "rita");
	items[90]=item( 19,5300, 1,"chunk mace" , "snoop");
	items[91]=item( 9,2000, 1,"claw" , "");
	items[92]=item( 2,900, 3,"clover hat" , "heath");
	items[93]=item( 13,2900, 1,"coconut leaves helmet" , "carter");
	items[94]=item( 8,1750, 1,"coconut armor" , "carter");
	items[95]=item( 7,1800, 1,"coconut helmet" , "carter");
	items[96]=item( 7,1650, 1,"coconut kneepads" , "carter");
	items[97]=item( 54,50000, 1,"cone helmet" , "travis");
	items[98]=item( 5,1300, 2,"crumby wizard hat" , "anoop");
	items[99]=item( 65,100000, 1,"crusader helmet" , "chance");
	items[100]=item(46 ,45000, 3,"crypt fire bow" , "wallace");
	items[101]=item( 37,29000, 0,"crystal heart shield" , "shane");
	items[102]=item( 37,25000, 2,"cursed pants" , "travis");
	items[103]=item( 40,31000, 2,"cursed robe" , "travis");
	items[104]=item( 8,4500, 2,"cursed shoe" , "sam");
	items[105]=item( 77,170000, 3,"cyborg armor" , "viper");
	items[106]=item( 83,205000, 3,"cyborg bow" , "sneed");
	items[107]=item( 81,210000, 3,"cyborg helmet" , "viper");
	items[108]=item( 75,152000, 3,"cyborg legs" , "viper");
	items[109]=item( 46,55000, 1,"death bringer" , "alpipa");
	items[110]=item( 52,40000, 1,"demons fury" , "wallace");
	items[340]=item( 51,67000, 3,"diamond studded bow", "travis");
	items[111]=item( 96,265000, 1,"dino blade" , "sneed");
	items[112]=item( 90,285000, 1,"dino helmet" , "sneed");
	items[113]=item( 81,190000, 1,"dino scale armor" , "sneed");
	items[114]=item( 81,159000, 1,"dino scale legs" , "sneed");
	items[115]=item( 83,155000, 1,"dino shield" , "shane");
	items[116]=item( 17,4500, 3,"double bell shoe" , "sam");
	items[117]=item( 29,22000, 3,"eagle slingshot" , "viper");
	items[118]=item( 27,17000, 2,"eagle staff" , "tiberius");
	items[119]=item( 70,90000, 1,"electric infuriator" , "wallace");
	items[120]=item( 60,86000, 1,"electric katana" , "wallace");
	items[121]=item( 112,300000, 2,"element armor" , "carter");
	items[122]=item( 65,6544000, 2,"element boot" , "sam");
	items[123]=item( 123,439000, 2,"element helmet" , "carter");
	items[124]=item( 106,280000, 2,"element legs" , "carter");
	items[125]=item( 100,273000, 2,"element staff" , "carter");
	items[126]=item( 95,246000, 2,"element wand" , "carter");
	items[127]=item( 8,1300, 3,"elf bell shoe" , "anoop, sam");
	items[128]=item( 5,800, 3,"elf shoe" , "anoop, sam");
	items[129]=item( 44,40000, 2,"enchanted armor" , "chance");
	items[130]=item( 65,90000, 2,"enchanted helmet" , "chance");
	items[131]=item( 40,33000, 2,"enchanted legs" , "chance");
	items[132]=item( 58,98000, 2,"fallen queens spectre" , "sneed");
	items[133]=item( 7,1000, 1,"fireman hatchet" , "anoop");
	items[134]=item( 25,17000, 3,"fish scale armor" , "tiberius");
	items[135]=item( 24,13000, 3,"fish scale legs" , "tiberius");
	items[136]=item( 35,36000, 3,"flak jacket" , "travis");
	items[137]=item( 69,148000, 3,"flaming needle bow" , "viper");
	items[138]=item( 63,116000, 3,"frosters bow" , "sneed");
	items[139]=item( 106,350000, 1,"frosting trident" , "sneed");
	items[140]=item( 3,500, 1,"full ski mask" , "heath");
	items[141]=item( 69,120000, 1,"future armor" , "sneed, viper");
	items[142]=item( 40,23000, 1,"future boot" , "sam");
	items[143]=item( 78,195000, 1,"future helmet" , "sneed, viper");
	items[144]=item( 65,95000, 1,"future legs" , "sneed, viper");
	items[145]=item( 72,95000, 1,"future shield" , "shane");
	items[146]=item( 7,2500, 0,"garbage can lid" , "shane");
	items[147]=item( 55,51000, 2,"ghost mask" , "travis");
	items[337]=item( 43,26000, 1, "gold helmet", "tiberius");
	items[148]=item( 40,22000, 1,"gold plate armor" , "tiberius");
	items[149]=item( 38,5950, 1,"gold plate legs" , "tiberius");
	items[150]=item( 1,80, 3,"green beanie" , "");
	items[151]=item( 30,22000, 3,"green face helmet" , "travis");
	items[152]=item( 1,200, 0,"green pants" , "heath");
	items[153]=item( 2,250, 0,"green shirt" , "");
	items[154]=item( 2,490, 0,"green shoe" , "carter");
	items[155]=item( 1,0, 0,"green shorts" , "");
	items[156]=item( 49,59000, 1,"guardians warhammer" , "alpipa");
	items[157]=item( 1,70, 0,"hair flower" , "rita");
	items[158]=item( 31,24000, 1,"halberd" , "alpipa");
	items[159]=item( 5,1200, 1,"half coconut" , "heath, carter");
	items[160]=item( 2,300, 1,"half ski mask" , "heath");
	items[161]=item( 4,480, 1,"hammer" , "heath");
	items[162]=item( 4,550, 3,"head wrap" , "");
	items[163]=item( 54,80000, 3,"heartstriker bow" , "chance");
	items[164]=item( 50,75000, 2,"heated staff" , "sneed");
	items[165]=item( 84,235000, 1,"helmet of hatred" , "sneed");
	items[166]=item( 12,2650, 1,"hockey mask" , "");
	items[167]=item( 45,30000, 1,"horned helmet" , "travis");
	items[168]=item( 87,285000, 0,"hybrid helmet" , "chance");
	items[169]=item( 81,125000, 1,"ice blade of gods" , "wallace");
	items[170]=item( 55,48000, 1,"ice hammer" , "wallace");
	items[171]=item( 101,345000, 1,"imperial armor" , "sneed");
	items[172]=item( 65,65000, 1,"imperial boot" , "sam");
	items[173]=item( 110,470000, 1,"imperial helmet" , "sneed");
	items[174]=item( 98,285000, 1,"imperial legs" , "sneed");
	items[175]=item( 40,36000, 2,"indian wand" , "viper");
	items[176]=item( 88,240000, 3,"industrial armor" , "viper");
	items[177]=item( 90,275000, 3,"industrial helmet" , "viper");
	items[178]=item( 84,230000, 3,"industrial legs" , "viper");
	items[179]=item( 36,19000, 2,"jester pants" , "travis");
	items[180]=item( 40,25000, 2,"jester shirt" , "travis");
	items[338]=item( 50,35000, 2, "jester hat", "travis");
	items[181]=item( 29,1200, 1,"knight armor" , "snoop");
	items[182]=item( 27,10000, 1,"knight armor legs" , "snoop");
	items[183]=item( 35,18000, 1,"knight helmet" , "snoop");
	items[184]=item( 13,3100, 3,"lazer shades" , "viper");
	items[185]=item( 3,900, 3,"leaf bow" , "carter, anoop");
	items[186]=item( 10,2800, 3,"leaf pad bow" , "anoop");
	items[187]=item( 11,3400, 3,"leather archer armor" , "alpipa");
	items[188]=item( 10,3000, 3,"leather armor" , "alpipa");
	items[189]=item( 14,3400, 3,"leather helmet" , "alpipa");
	items[190]=item( 10,2800, 3,"leather legs" , "alpipa");
	items[191]=item( 70,128000, 1,"legs of hatred" , "sneed");
	items[192]=item( 75,110000, 1,"light sword" , "sneed");
	items[193]=item( 12,3100, 1,"log splitting axe" , "carter");
	items[194]=item( 9,1850, 1,"machete" , "carter");
	items[195]=item( 33,12000, 2,"magician armor" , "snoop");
	items[196]=item( 28,7000, 2,"magician armor legs" , "snoop");
	items[197]=item( 52,38000, 1,"magnesium armor" , "wallace");
	items[198]=item( 23,8000, 1,"magnesium boots" , "sam");
	items[199]=item( 60,65000, 1,"magnesium helmet" , "wallace");
	items[200]=item( 50,30000, 1,"magnesium legs" , "wallace");
	items[201]=item( 5,810, 1,"meat cleaver" , "snoop");
	items[202]=item( 30,22000, 3,"mechanic wing bow" , "snoop");
	items[203]=item( 9,3000, 3,"medium bow" , "anoop");
	items[204]=item( 40,48000, 1,"mega sword" , "snoop");
	items[205]=item( 34,16000, 2,"metal ballerina outfit" , "rita");
	items[206]=item( 31,14000, 2,"metal ballerina legs" , "rita");
	items[207]=item( 35,21000, 2,"metal cat helmet" , "rita");
	items[208]=item( 26,5100, 2,"mocap pants" , "viper");
	items[209]=item( 28,8500, 2,"mocap suit" , "viper");
	items[210]=item( 15,4300, 1,"monster skull" , "");
	items[211]=item( 100,205000, 1,"mummified axe" , "sneed");
	items[212]=item( 61,75000, 2,"mushroom helmet" , "chance");
	items[213]=item( 50,55000, 3,"natures bow" , "chance");
	items[214]=item( 18,8400, 2,"natures staff" , "snoop");
	items[215]=item( 90,225000, 2,"neon magic helmet" , "viper");
	items[216]=item( 65,110000, 2,"neon magic legs" , "viper");
	items[217]=item( 76,120000, 2,"neon magic suit" , "viper");
	items[218]=item( 58,98000, 3,"night glow bow" , "chance");
	items[219]=item( 34,16000, 2,"night glow wand", "travis");
	items[220]=item( 23,13000, 2,"nightingale staff" , "snoop");
	items[221]=item( 23,5000, 2,"nightingale wand" , "snoop");
	items[339]=item( 34,28000, 2, "ocean staff", "travis");
	items[222]=item( 4,1350, 3,"oriental hat" , "");
	items[223]=item( 12,3300, 1,"pickaxe" , "carter");
	items[224]=item( 63,80000, 2,"pink crystal armor" , "rita");
	items[225]=item( 40,16000, 2,"pink crystal boot" , "sam");
	items[226]=item( 77,170000, 2,"pink crystal helmet" , "rita");
	items[227]=item( 60,71000, 2,"pink crystal legs" , "rita");
	items[228]=item( 3,240, 1,"plastic saber" , "heath");
	items[229]=item( 46,80000, 2,"protector helmet" , "sneed");
	items[230]=item( 40,47000, 2,"protector legs" , "sneed");
	items[231]=item( 24,10500, 0,"protector shield" , "shane");
	items[232]=item( 44,58000, 2,"protector suit" , "sneed");
	items[233]=item( 16,5000, 1,"pumpkin helmet" , "");
	items[234]=item( 17,6000, 1,"racing helmet" , "alpipa");
	items[235]=item( 86,185000, 1,"reapers scythe" , "wallace");
	items[236]=item( 1,200, 0,"red beanie" , "heath");
	items[237]=item( 4,150, 0,"red pants" , "");
	items[238]=item( 1,110, 1,"red plastic sword" , "heath");
	items[239]=item( 3,250, 0,"red shirt" , "heath");
	items[240]=item( 8,4000, 2,"red wizard hat" , "anoop");
	items[241]=item( 8,2800, 2,"red wizard pants" , "anoop");
	items[242]=item( 9,3200, 2,"red wizard robe" , "anoop");
	items[243]=item( 32,26000, 3,"reinforced bush armor" , "travis");
	items[244]=item( 31,21100, 3,"reinforced bush legs" , "travis");
	items[245]=item( 100,239000, 2,"relic armor" , "travis");
	items[246]=item( 53,28000, 2,"relic boot" , "sam");
	items[247]=item( 110,380000, 2,"relic helmet" , "travis");
	items[248]=item( 94,213000, 2,"relic legs" , "travis");
	items[249]=item( 28,9000, 2,"reptile wand" , "tiberius");
	items[250]=item( 19,11000, 3,"rich mans bow" , "snoop");
	items[251]=item( 90,250000, 1,"robot armor" , "viper");
	items[252]=item( 98,365000, 1,"robot helmet" , "viper");
	items[253]=item( 86,210000, 1,"robot legs" , "viper");
	items[254]=item( 92,220000, 0,"robot shield" , "shane");
	items[255]=item( 19,7000, 1,"roman helmet" , "alpipa");
	items[256]=item( 9,2400, 1,"roman leggings" , "alpipa");
	items[257]=item( 10,2800, 1,"roman robe" , "alpipa");
	items[258]=item( 48,52000, 2,"royal armor" , "sneed");
	items[259]=item( 69,112000, 2,"royal helmet" , "sneed");
	items[260]=item( 43,41000, 2,"royal legs" , "sneed");
	items[261]=item( 12,2700, 1,"rusty scimitar" , "carter");
	items[262]=item( 5,800, 1,"sai" , "anoop");
	items[263]=item( 51,70000, 3,"samurai armor" , "sneed");
	items[264]=item( 57,100000, 3,"samurai helmet" , "sneed");
	items[265]=item( 50,60000, 3,"samurai legs" , "sneed");
	items[266]=item( 3,350, 0,"shades" , "tiberius");
	items[267]=item( 68,145000, 2,"shaman staff" , "anoop");
	items[268]=item( 55,90000, 2,"shaman wand" , "anoop");
	items[269]=item( 6,800, 1,"short sword" , "carter");
	items[270]=item( 3,500, 1,"sickle" , "heath");
	items[271]=item( 17,3600, 1,"single battle axe" , "alpipa");
	items[272]=item( 109,255000, 1,"single godly blade" , "tiberius");
	items[273]=item( 83,143000, 1,"single hatred blade" , "sneed");
	items[274]=item( 10,2400, 2,"single sphere wand" , "alpipa");
	items[275]=item( 140,576000, 1,"skull crusher" , "wallace");
	items[276]=item( 133,550000, 1,"skull crusher armor" , "chance");
	items[277]=item( 85,150000, 1,"skull crusher boot" , "sam");
	items[278]=item( 145,700000, 1,"skull crusher helmet" , "chance");
	items[279]=item( 127,435000, 1,"skull crusher legs" , "chance");
	items[280]=item( 124,370000, 1,"skull crusher shield" , "shane");
	items[281]=item( 24,12500, 1,"skull spear" , "tiberius");
	items[282]=item( 11,2800, 1,"sledgehammer" , "carter");
	items[283]=item( 1,234, 3,"slingshot" , "");
	items[284]=item( 1,500, 3,"small bow" , "heath");
	items[285]=item( 134,350000, 1,"small skull crusher" , "wallace");
	items[286]=item( 11,3400, 0,"smiley tin shield" , "shane");
	items[287]=item( 62,80000, 1,"snout zinc helmet" , "wallace");
	items[288]=item( 34,16000, 2,"sorcerer pants" , "travis");
	items[289]=item( 38,20000, 2,"sorcerer robe" , "travis");
	items[290]=item( 45,26000, 2,"sorcerers copter hat" , "travis");
	items[291]=item( 40,19000, 2,"sorcerer hat and glasses" , "travis");
	items[292]=item( 32,15000, 1,"spartan helmet" , "snoop");
	items[293]=item( 44,57000, 2,"spherical staff" , "sneed");
	items[294]=item( 50,37000, 1,"spiked dino boots" , "sam");
	items[295]=item( 41,65000, 3,"spiked shell helmet" , "travis");
	items[296]=item( 7,1200, 2,"star wand" , "anoop");
	items[297]=item( 15,3000, 1,"steel boot" , "sam");
	items[298]=item( 33,29000, 3,"steel helmet hat" , "travis");
	items[299]=item( 1,50, 1,"stick" , "");
	items[300]=item( 34,15000, 1,"stone armor" , "tiberius");
	items[301]=item( 31,13500, 1,"stone armor legs" , "tiberius");
	items[302]=item( 37,22000, 1,"stone helmet" , "tiberius");
	items[303]=item( 30,15600, 0,"stone shield" , "shane");
	items[304]=item( 9,2900, 0,"stop sign" , "shane");
	items[305]=item( 39,46000, 3,"strong armor" , "chance");
	items[306]=item( 37,14000, 0,"strong basket helmet" , "snoop");
	items[307]=item( 42,53000, 3,"strong full helmet" , "chance");
	items[308]=item( 37,38000, 3,"strong legs" , "chance");
	items[309]=item( 26,10000, 1,"sugarloaf helmet" , "alpipa");
	items[310]=item( 5,620, 0,"suit" , "carter");
	items[311]=item( 4,610, 0,"suit pants" , "carter");
	items[312]=item( 32,16000, 1,"super hero shirt" , "tiberius");
	items[313]=item( 12,4200, 1,"scythe" , "alpipa");
	items[314]=item( 21,9900, 1,"teardrop blade" , "alpipa");
	items[315]=item( 15,8300, 3,"thorn bow" , "anoop");
	items[316]=item( 8,2000, 3,"triple leaf bow" , "carter, anoop");
	items[317]=item( 37,34000, 2,"tropical staff" , "travis");
	items[318]=item( 0,300, 0,"turkey" , "geraldo");
	items[319]=item( 23,11000, 1,"two hand mace" , "snoop");
	items[320]=item( 8,1800, 1,"umbrella" , "rita");
	items[321]=item( 46,54000, 2,"wand of blessing" , "sneed");
	items[322]=item( 0,120, 0,"watermelon" , "geraldo");
	items[323]=item( 1,125, 0,"white shirt" , "");
	items[324]=item( 1,50, 0,"white shoes" , "");
	items[325]=item( 36,25000, 2,"winged diamond wand" , "chance");
	items[326]=item( 36,13000, 2,"witch hat" , "tiberius");
	items[327]=item( 58,65000, 2,"wizard hat mask" , "chance");
	items[328]=item( 15,4200, 0,"wood metal shield" , "shane");
	items[329]=item( 7,2000, 0,"wood scrap shield" , "carter, shane");
	items[330]=item( 5,720, 1,"wooden bat" , "carter");
	items[331]=item( 14,4900, 1,"wooden spear" , "tiberius");
	items[332]=item( 4,650, 0,"wrapped legs" , "");
	items[333]=item( 2,300, 0,"yellow pants" , "heath");
	items[334]=item( 55,51000, 1,"zinc armor" , "wallace");
	items[335]=item( 27,14000, 1,"zinc boots" , "sam");
	items[336]=item( 52,46000, 1,"zinc legs" , "wallace");
	//		items[337]=item(26000, 1, "gold helmet", "tiberius");
	//		items[338]=item(35000, 2, "jester hat", "travis");
	//		items[339]=item(28000, 2, "ocean staff", "travis");
	//		items[340]=item( ,67000, 3,"diamond studded bow", "travis");
	//		items[341]=item(6800, 1, "bronze plate legs", "snoop");
	//		items[342]=item(3200, 3, "archer leather legs", "alpipa");
	items[343]=item( 0,55000, 0,"book of power" , "lewis");
	items[344]=item( 0,55000, 0,"book of magic" , "lewis");
	items[345]=item( 0,55000, 0,"book of range" , "lewis");
	items[346]=item( 0,55000, 0,"book of dexterity" , "lewis");
	items[347]=item( 0,55000, 0,"book of health" , "lewis");
	items[348]=item( 0,55000, 0,"book of mp" , "lewis");
	items[349]=item( 0,55000, 0,"book of defense" , "lewis");
	items[350]=item( 0,210000, 0,"book of skill" , "lewis");
	items[351]=item( 128,445000, 3,"harpoon bow" , "ricardo");
	items[352]=item( 109,305000, 2,"analytic wand" , "ricardo");
	items[353]=item( 117,360000, 2,"analytic staff" , "ricardo");
	items[354]=item( 138,385000, 2,"serpent wand" , "ricardo");
	items[355]=item( 142,443000, 2,"serpent staff" , "ricardo");
	items[356]=item( 163,440000, 1,"acidic sword" , "ricardo");
	items[357]=item( 171,700000, 1,"two hand acid blade" , "ricardo");
	items[358]=item( 153,460000, 0,"acid shield" , "ricardo");
	items[359]=item( 174,750000, 1,"thors hammer" , "ricardo");
	items[360]=item( 47,32000, 1,"deep sea helmet" , "ricardo");
	items[361]=item( 135,505000, 3,"earth helmet" , "ricardo");
	items[362]=item( 142,510000, 2,"analytic helmet" , "ricardo");
	items[363]=item( 184,700000, 2,"serpent helmet" , "ricardo");
	items[364]=item( 167,835000, 1,"titanium helmet" , "ricardo");
	items[365]=item( 154,645000, 1,"titanium armor" , "ricardo");
	items[366]=item( 153,525000, 1,"titanium legs" , "ricardo");
	items[367]=item( 138,460000, 3,"earth armor" , "ricardo");
	items[368]=item( 144,435000, 3,"earth legs" , "ricardo");
	items[369]=item( 135,375000, 2,"analytic armor" , "ricardo");
	items[370]=item( 138,357000, 2,"analytic legs" , "ricardo");
	items[371]=item( 179,550000, 2,"serpent armor" , "ricardo");
	items[372]=item( 173,470000, 2,"serpent legs" , "ricardo");
	items[373]=item( 184,1050000, 1,"acidic helmet" , "ricardo");
	items[374]=item( 185,800000, 1,"acidic armor" , "ricardo");
	items[375]=item( 184,650000, 1,"acidic legs" , "ricardo");
	items[376]=item( 1,200, 0,"pet striped beanie" , "val");
	items[377]=item( 1,90, 0,"pet bowtie" , "val");
	items[378]=item( 4,1150, 0,"pet melon helmet" , "val");
	items[379]=item( 5,1500, 0,"pet oriental hat" , "val");
	items[380]=item( 4,1900, 0,"pet archer hat" , "val");
	items[381]=item( 6,1300, 0,"pet crumby hat" , "val");
	items[382]=item( 16,5500, 0,"pet army helmet" , "val");
	items[383]=item( 24,2300, 0,"pet wizard hat" , "val");
	items[384]=item( 33,12500, 0,"pet witch hat" , "val");
	items[385]=item( 27,12000, 0,"pet spartan helmet" , "val");
	items[386]=item( 33,19000, 0,"pet stone helmet" , "val");
	items[387]=item( 23,13000, 0,"pet apollo helmet" , "val");
	items[388]=item( 35,35000, 0,"pet strong helmet" , "val");
	items[389]=item( 56,98000, 0,"pet samurai helmet" , "val");
	items[390]=item( 48,33000, 0,"pet jester hat" , "val");
	items[391]=item( 40,30000, 0,"pet horned helmet" , "val");
	items[392]=item( 51,46000, 0,"pet cone helmet" , "val");
	items[393]=item( 45,38000, 0,"pet adamantium helmet" , "val");
	items[394]=item( 87,275000, 0,"pet dino scale helmet" , "val");
	items[395]=item( 76,180000, 0,"pet cyborg helmet" , "val");
	items[396]=item( 117,385000, 0,"pet element helmet" , "val");
	items[397]=item( 121,510000, 0,"pet beholder helmet" , "val");
	items[398]=item( 43,70000, 0,"pet protector helmet" , "val");
	items[399]=item( 2,275, 0,"paper bag", "heath");
	items[400]=item( 4,700, 2,"santa claus hat", "");
	items[401]=item( 208,1350000, 1,"kreeton helmet", "bartholomew");
	items[402]=item( 204,820000, 1,"kreeton legs", "bartholomew");
	items[403]=item( 208,995000, 1,"kreeton armor", "bartholomew");
	items[404]=item( 190,525000, 1,"kreeton cutter", "bartholomew");
	items[405]=item( 201,860000, 1,"eye of kreeton", "bartholomew");
	items[406]=item( 189,551000, 0,"kreeton shield", "bartholomew");
	items[407]=item( 101,95000, 3,"earth boot", "sam");
	items[408]=item( 90,80000, 2,"serpent boot", "sam");
	items[409]=item( 110,210000, 1,"acid boot", "sam");
	items[410]=item( 160,400000, 1,"bladed boot", "sam");
	items[411]=item( 263,1500000, 1,"electric barracuda", "bartholemew");
	items[412]=item( 246,900000, 1,"brooding fire axe", "bartholemew");
	items[413]=item( 258,1500000, 1,"bladed legs", "bartholemew");
	items[414]=item( 260,1700000, 1,"bladed armor", "bartholemew");
	items[415]=item( 263,2150000, 1,"bladed helmet", "bartholemew");
	items[416]=item( 179,880000, 3,"repguana bow", "bartholemew");
	items[417]=item( 189,840000, 3,"repguana legs", "bartholemew");
	items[418]=item( 189,1000000, 3,"repguana armor", "bartholemew");
	items[419]=item( 189,1100000, 3,"reguana helmet", "bartholemew");
	items[420]=item( 192,800000, 2,"darkane staff", "bartholemew");
	items[421]=item( 177,680000, 2,"darkane wand", "bartholemew");
	items[422]=item( 222,875000, 2,"darkane legs", "bartholemew");
	items[423]=item( 223,1050000, 2,"darkane armor", "bartholemew");
	items[424]=item( 233,1300000, 2,"darkane hood helmet", "bartholemew");
	items[425]=item( 1,280, 4,"airsoft gun", "heath");
	items[426]=item( 2,550, 4,"paintball gun", "heath");
	items[427]=item( 1,160, 4,"paper hat", "heath");
	items[428]=item( 4,560, 4,"koon hat", "heath");
	items[429]=item( 5,1250, 4,"detective hat", "heath");
	items[430]=item( 20,8100, 4,"cowboy hat", "heath");
	items[431]=item( 9,2900, 4,"cowboy shirt", "heath");
	items[432]=item( 9,2500, 4,"cowboy pants", "heath");
	items[433]=item( 18,10500, 4,"revolver", "snoop");
	items[434]=item( 26,17000, 4,"mac10", "snoop");
	items[435]=item( 31,25000, 4,"mp5", "snoop");
	items[436]=item( 5,1710, 4,"mexican shirt", "snoop");
	items[437]=item( 4,1650, 4,"mexican pants", "snoop");
	items[438]=item( 8,4300, 4,"sombrero", "snoop");
	items[439]=item( 12,4900, 4,"koon outfit", "snoop");
	items[440]=item( 11,4300, 4,"koon pants", "snoop");
	items[441]=item( 36,15000, 4,"masked cowboy hat", "snoop");
	items[442]=item( 76,156000, 4,"cowboy knight helmet", "chance");
	items[443]=item( 66,83000, 4,"steel masked helmet", "chance");
	items[444]=item( 53,35050, 4,"pointed pirate hat", "chance");
	items[445]=item( 55,85000, 4,"m16", "wallace");
	items[446]=item( 83,200000, 4,"sniper rifle", "wallace");
	items[447]=item( 40,41000, 4,"shotgun", "tiberius");
	items[448]=item( 53,70000, 4,"tommy gun", "tiberius");
	items[449]=item( 58,100000, 4,"es c90", "tiberius");
	items[450]=item( 62,115000, 4,"ak47", "tiberius");
	items[451]=item( 91,220000, 4,"chemical mask", "tiberius");
	items[452]=item( 27,11500, 4,"cowboy belt hat", "carter");
	items[453]=item( 14,8200, 4,"handgun", "carter");
	items[454]=item( 8,2900, 4,"potato gun", "carter");
	items[455]=item( 100,274000, 4,"xm8 rifle", "ricardo");
	items[456]=item( 111,350000, 4,"machine gun", "ricardo");
	items[457]=item( 128,420000, 4,"chaingun", "ricardo");
	items[458]=item( 170,650000, 4,"bazooka", "ricardo");
	items[459]=item( 189,850000, 4,"rayon gun", "ricardo");
	items[460]=item( 7,1250, 4,"cowboy boot", "sam");
	items[461]=item( 20,5000, 4,"pirate boot", "sam");
	items[462]=item( 45,22000, 4,"chemical boot", "sam");
	items[463]=item( 100,101000, 4,"valor boot", "sam");
	items[464]=item( 18,8000, 0,"pet cowboy hat", "val");
	items[465]=item( 38,25000, 0,"pet pirate hat", "val");
	items[466]=item( 125,500000, 0,"pet valor helmet", "val");
	items[467]=item( 200,800000, 0,"pet pirate helmet", "val");
	items[468]=item( 0,55000, 4,"book of artillery", "lewis");
	items[469]=item( 7,700, 0,"fishing pole", "milton");
	items[470]=item( 6,30, 0,"fishing net", "payvault");
	items[471]=item( 75, 72000, 4,"chemical armor", "geraldo");
	items[472]=item( 75, 70000, 4,"chemical legs", "geraldo");
//	items[473]=item( 0,250, 0,"weeping willow seed", "craft-man");
//	items[474]=item( 0,180, 0,"dead tree seed", "craft-man");
//	items[475]=item( 0,120, 0,"blue mushroom seed", "craft-man");
//	items[476]=item( 0,100, 0,"red mushroom seed", "craft-man");
//	items[477]=item( 0,85, 0,"goof tree seed", "craft-man");
//	items[478]=item( 0,115, 0,"chestnut tree seed", "craft-man");
//	items[479]=item( 0,135, 0,"pine tree seed", "craft-man");
//	items[480]=item( 0,140, 0,"jungle tree seed", "craft-man");
//	items[481]=item( 0,140, 0,"robot tree seed", "craft-man");
//	items[482]=item( 0,190, 0,"tropical tree seed", "craft-man");
//	items[483]=item( 0,300, 0,"thorn tree seed", "craft-man");
//	items[484]=item( 0,170, 0,"snowy tree seed", "craft-man");
	items[485]=item( 0,35, 0,"palm tree log", "tree");
	items[486]=item( 0,180, 0,"purple tree log", "tree");
	items[487]=item( 0,87, 0,"weeping willow log", "tree");
	items[488]=item( 0,28, 0,"dead tree log", "tree");
	items[489]=item( 0,36, 0,"blue mushroom log", "tree");
	items[490]=item( 0,36, 0,"red mushroom log", "tree");
	items[491]=item( 0,24, 0,"goof tree log", "tree");
	items[492]=item( 0,42, 0,"chestnut tree log", "tree");
	items[493]=item( 0,115, 0,"pine tree log", "tree");
	items[494]=item( 0,150, 0,"jungle tree log", "tree");
	items[495]=item( 0,49, 0,"robot tree log", "tree");
	items[496]=item( 0,45, 0,"tropical tree log", "tree");
	items[497]=item( 0,210, 0,"thorn tree log", "tree");
	items[498]=item( 0,45, 0,"snowy tree log", "tree");
	items[499]=item( 370,5600000, 1,"mithril helmet", "jerry");
	items[500]=item( 355,4100000, 1,"mithril armor", "jerry");
	items[501]=item( 354,4700000, 1,"mithril legs", "jerry");
	items[502]=item( 325,4100000, 2,"phantom hood", "jerry");
	items[503]=item( 320,3900000, 2,"phantom robe", "jerry");
	items[504]=item( 320,3600000, 2,"phantom pants", "jerry");
	items[505]=item( 310,5100000, 3,"divine helmet", "jerry");
	items[506]=item( 315,3800000, 3,"divine armor", "jerry");
	items[507]=item( 311,3650000, 3,"divine legs", "jerry");
	items[508]=item( 325,3800000, 4,"enforcer helmet", "scott");
	items[509]=item( 328,4055000, 4,"enforcer armor", "scott");
	items[510]=item( 318,3850000, 4,"enforcer legs", "scott");
	items[511]=item( 375,6400000, 1,"frozen mithril axe", "scott");
	items[512]=item( 360,3100000, 1,"god dagger", "scott");
	items[513]=item( 301,2600000, 2,"phantom wand", "scott");
	items[514]=item( 320,3700000, 2,"phantom staff", "scott");
	items[515]=item( 300,3550000, 3,"divine bow", "scott");
	items[516]=item( 360,4000000, 0,"mithril shield", "scott");
	items[517]=item( 353,5050000, 4,"enforcer gun", "wood man steve");
	items[518]=item( 0,7000, 0,"robot bar", "wood man steve");
	items[519]=item( 0,6200, 0,"jungle wood", "wood man steve");
	items[520]=item( 0,5500, 0,"stacked wood", "wood man steve");
	items[521]=item( 0,7100, 0,"thorn wood", "wood man steve");
	items[522]=item( 0,6300, 0,"snow covered wood", "wood man steve");
	items[523]=item( 0,5000, 0,"palm tree wood", "wood man tim");
	items[524]=item( 0,4500, 0,"blue mushroom cube", "wood man tim");
	items[525]=item( 0,4400, 0,"red mushroom cube", "wood man tim");
	items[526]=item( 0,5400, 0,"purple sheet wood", "wood man tim");
	items[527]=item( 0,5800, 0,"willow wood", "wood man tim");
	items[528]=item( 0,4900, 0,"junk wood", "wood man tim");
	items[529]=item( 0,4700, 0,"colored wood", "wood man tim");
	items[530]=item( 0,6000, 0,"chestnut wood", "wood man tim");
	items[531]=item( 0,5800, 0,"pine block", "wood man tim");
	items[532]=item( 2,85, 0,"chicken hat", "payvault");
	items[533]=item( 3,85, 0,"chicken outfit", "payvault");
	items[534]=item( 2,85, 0,"chicken pants", "payvault");
	items[535]=item( 70,13, 0,"chainsaw", "payvault");
	items[536]=item( 435, 7500000, 1,"cyro thorn blade", "dan");
	items[537]=item( 453, 12500000, 1,"cyro x force", "dan");
	items[538]=item( 375, 7100000, 3,"mystic tribal bow", "dan");
	items[539]=item( 373, 5900000, 2,"hydro tech wand", "dan");
	items[540]=item( 390, 8050000, 2,"hydro tech staff", "dan");
	items[541]=item( 395, 9050000, 4,"skull bone gun", "dan");
	items[542]=item( 371, 7300000, 4,"atomic helmet", "hubert");
	items[543]=item( 375, 8200000, 3,"mystical tribal mask", "hubert");
	items[544]=item( 390, 8800000, 2,"hydro tech helmet", "hubert");
	items[545]=item( 450, 9400000, 1,"cyro helmet", "hubert");
	items[546]=item( 365, 6900000, 4,"atomic suit", "hubert");
	items[547]=item( 367, 7650000, 3,"mystical tribal armor", "hubert");
	items[548]=item( 385, 7250000, 2,"hydro tech suit", "hubert");
	items[549]=item( 430, 8100000, 1,"cyro armor", "hubert");
	items[550]=item( 360, 6700000, 4,"atomic legs", "dan");
	items[551]=item( 360, 7200000, 3,"mystical tribal legs", "dan");
	items[552]=item( 381, 7000000, 2,"hydro tech legs", "dan");
	items[553]=item( 425, 7700000, 1,"cyro legs", "hubert");
	items[554]=item( 168, 550000, 2,"hydro tech boot", "sam");
	items[555]=item( 170, 500000, 3,"mystical tribal boot", "sam");
	items[556]=item( 200, 615000, 4,"atomic boot", "sam");
	items[557]=item( 225, 1200000, 1,"cyro boot", "sam");
	items[558]=item( 440, 12110000, 0,"cyro shield", "shane");
	items[559]=item( 1, 65, 0,"monkey tail", "payvault");
	items[560]=item( 15, 80, 0,"red cape", "payvault");
	items[561]=item( 25, 75, 0,"jetpack", "payvault");
	items[562]=item( 55, 70, 0,"dino tail", "payvault");
	items[563]=item( 65, 145, 0,"wings", "payvault");
	//items[564]=item( 0, 0, 0,"", "");


	//	pet pets[60];  int power, int health, int defense, int dexterity, int cost
	//				   string type (name), string ability1, string ability2, string ability3, string ability4
	pet pets[21];
	pets[0]=pet(0, 0, 0, 0, 0, "na", "na", "na", "na");
			pets[1]=pet(4, 16, 2, 4, 200000, "tebra", "full attack", "full power attack", "half loot");
			pets[2]=pet(6, 23, 3, 1, 275000, "marshy", "full power attack", "full attack", "full on defensive");
			pets[3]=pet(2, 10, 1, 2, 150000, "baby bounce", "full loot", "half loot half attack", "25% pick up 75% attack");
			pets[4]=pet(2, 14, 1, 4, 170000, "petri", "full loot", "half loot half attack", "25% pick up 75% attack");
			pets[5]=pet(6, 26, 3, 2, 290000, "gibler", "full on defensive mode", "full attack", "half coin pickup 75% attack");
			pets[6]=pet(4, 17, 2, 7, 310000, "fisky","quick attack", "full loot", "increase luck");
			pets[7]=pet(3, 13, 6, 4, 305000, "roblost", "full power attack", "full attack", "full on defensive");
			pets[8]=pet(2, 12, 4, 2, 175000, "pumpman", "full on defensive", "half defensive half attack", "full attack");
			pets[9]=pet(3, 19, 2, 4, 200000, "chippy", "full attack", "25% pick up 75% attack", "increase luck");
			pets[10]=pet(3, 15, 2, 5, 195000, "thumper", "quick attack", "full loot", "half coin pickup 75% attack");
			pets[11]=pet(4, 30, 3, 4, 362500, "nooter", "full attack", "booster", "increase player dex");
			pets[12]=pet(2, 11, 1, 6, 180000, "gobloid", "full power attack", "increase luck", "full attack");
			pets[13]=pet(7, 28, 3, 1, 280000, "ritardo", "full extreme attack", "full power attack", "full attack");
			pets[14]=pet(7, 14, 2, 5, 300000, "ozich", "increase player dex", "quick attack", "full attack");
			pets[15]=pet(3, 18, 2, 3, 187500, "topper", "full attack", "booster", "half defensive half attack");
			pets[16]=pet(6, 15, 5, 2, 275000, "bunyan", "full on defensive", "half defensive half attack", "booster");
			pets[17]=pet(2, 19, 1, 4, 180000, "quackster", "increase player dex", "half coin pickup 75% attack", "increase luck");
			pets[18]=pet(7, 15, 4, 2, 235000, "dwimplepike", "full attack", "full power attack", "half loot half attack");
			pets[19]=pet(7, 20, 3, 4, 327500, "squatch", "full extreme attack", "full attack", "half loot half attack");
			pets[20]=pet(9, 24, 3, 3, 350000, "stalkling", "quick attack", "full loot", "half coin pickup 75% attack");
			//				pets[21]=pet(, , , , , "", "", "", ""),
			//				pets[22]=pet(, , , , , "", "", "", ""),
			//				pets[23]=pet(, , , , , "", "", "", ""),
			//				pets[24]=pet(, , , , , "", "", "", ""),
			//				pets[25]=pet(, , , , , "", "", "", ""),
			//				pets[26]=pet(, , , , , "", "", "", ""),
			//				pets[27]=pet(, , , , , "", "", "", ""),
			//				pets[28]=pet(, , , , , "", "", "", ""),
			//				pets[29]=pet(, , , , , "", "", "", ""),
			//				pets[30]=pet(, , , , , "", "", "", ""),
			//				pets[31]=pet(, , , , , "", "", "", ""),
			//				pets[32]=pet(, , , , , "", "", "", ""),
			//				pets[33]=pet(, , , , , "", "", "", ""),
			//				pets[34]=pet(, , , , , "", "", "", ""),
			//				pets[35]=pet(, , , , , "", "", "", ""),
			//				pets[36]=pet(, , , , , "", "", "", ""),
			//				pets[37]=pet(, , , , , "", "", "", ""),
			//				pets[38]=pet(, , , , , "", "", "", ""),
			//				pets[39]=pet(, , , , , "", "", "", ""),
			//				pets[40]=pet(, , , , , "", "", "", ""),
			//				pets[41]=pet(, , , , , "", "", "", ""),
			//				pets[42]=pet(, , , , , "", "", "", ""),
			//				pets[43]=pet(, , , , , "", "", "", ""),
			//				pets[44]=pet(, , , , , "", "", "", ""),
			//				pets[45]=pet(, , , , , "", "", "", ""),
			//				pets[46]=pet(, , , , , "", "", "", ""),
			//				pets[47]=pet(, , , , , "", "", "", ""),
			//				pets[48]=pet(, , , , , "", "", "", ""),
			//				pets[49]=pet(, , , , , "", "", "", ""),
			//				pets[50]=pet(, , , , , "", "", "", ""),
			//				pets[51]=pet(, , , , , "", "", "", ""),
			//				pets[52]=pet(, , , , , "", "", "", ""),
			//				pets[53]=pet(, , , , , "", "", "", ""),
			//				pets[54]=pet(, , , , , "", "", "", ""),
			//				pets[55]=pet(, , , , , "", "", "", ""),
			//				pets[56]=pet(, , , , , "", "", "", ""),
			//				pets[57]=pet(, , , , , "", "", "", ""),
			//				pets[58]=pet(, , , , , "", "", "", ""),
			//				pets[59]=pet(, , , , , "", "", "", ""),
			//				pets[60]=pet(, , , , , "", "", "", ""),

			cout << "*********************************************\n******* Helmet Heroes Assistant v1.9 ********\n*********************************************\n**************** By: Caefer *****************\n*********************************************\n";
	while(menu<11){
		try{
			if(menu == 1){
				int sLv = 0; //starting level
				int fLv = 0; //finishing level
				int subtr;

				cout << "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n";
				cout << "Enter current level: ";

				Get(sLv);
				cout << "Enter level you want to reach: ";
				Get(fLv);
				cout << "How much XP do you currently have towards your next level (not total xp)? ";
				Get(subtr);
				if(sLv <= fLv){
					long long mult1, mult2, add1, sqrd, final = 0;
					for(int i = sLv; i < fLv; ++i){//This follows the algorithm used to calculate the experience needed to get
						mult1 = 50 * i;			   //the next level then adds it up to the total level and it's corresponding exp.
						sqrd = i * i;
						mult2 = sqrd * 1.1;
						add1 = mult1 + mult2;
						final = final + add1;
					}
					cout.precision(10);
					cout << "\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n";
					cout << "The xp you need to reach level " << fLv <<" is about " << final - subtr << ".\n";
					cout << "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n \n";
				}
				menu=0;
			}
			else if(menu == 2){
				int lvl, range, lr, ur;
				cout << "**** Item by Level Guide ****\n(Enter '0' to quit)";
				cout << "Enter a level to see the items that become available for it: ";
				Get(lvl);
				cout<< "Enter the range of levels to get items from: \n(enter 0 to see items from just one level.)\n ==> ";
				Get(range);
				if(lvl == 0){
					menu = 0;
				}
				if(lvl<=453){
					int count = 0;
					if(range != 0){
						ur = lvl + range;
						if(lvl - range <= 0){
							lr = 1;
						}
						else{
							lr = lvl - range;
						}
						cout << "In the level range of "<< lr << " to " << ur << ", you will be able to use the following items:\n\n";

						for(int j = 1; j<maxItems;j++){
							if(items[j].lv>=(lr)&&items[j].lv<=(ur)){
								cout<< items[j].n << "\n";
								count++;
							}
							else{
								menu=0;
							}

						}
						if(count==0){
							cout<<"There are no items available in that range.";
							menu=0;
						}
					}
					else{
						cout << "At level "<< lvl <<", you will be able to use the following items:\n\n";
						int count = 0;
						for(int j = 1; j<maxItems;j++){
							if(items[j].lv>=(lvl - range)&&items[j].lv<=(lvl + range)){
								cout<< items[j].n << "\n";
								count++;
							}

							else{
								menu=0;
							}
						}
						if(count==0){
							cout<<"There are no items available in that range.";
							menu=0;
						}

					}

				}

				else{
					cout<< "All items are usable after level 453.";
					menu=0;
				}
			}
			else if(menu==3){
				int stat1, weaponupr1, weaponlwr1, weaponupr2, weaponlwr2, enemydef, mindmg, maxdmg, percentcrit;
				double critmult, dexmin, dexmax;
				cout<<"***** Damage Calculator *****\n";
				cout<<"Enter the stat value of your class choice\n(strength for warrior, range for archer, magic for mage)\n";
				cout<<"Please note, this should be a number, not your class.\n\n ==> ";
				Get(stat1);
				cout<<"Enter your critical hit damage modifier in percent: ";
				Get(percentcrit);
				cout<<"Enter the damage values asked for below, \nif you do not have a secondary weapon just enter '0' when asked\n";
				cout<<"Primary weapon minimum damage: ";
				Get(weaponlwr1);
				cout<<"Primary weapon maximum damage: ";
				Get(weaponupr1);
				cout<<"Secondary weapon minimum damage: ";
				Get(weaponlwr2);
				cout<<"Secondary weapon maximum damage: ";
				Get(weaponupr2);
				cout<<"And finally, Enter the defense of the monster you are fighting: ";
				Get(enemydef);
				cout<<"\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n";
				menu=0;

				critmult=percentcrit/100;
				mindmg=(stat1*(weaponlwr1+weaponlwr2))/enemydef;
				maxdmg=(stat1*(weaponupr1+weaponupr2))/enemydef;
				dexmin=((mindmg)*critmult);
				dexmax=((maxdmg)*critmult);
				cout<<"\nYou can do between "<< mindmg << " and "<< maxdmg <<" damage.\nWith a critical hit you can do between "<< dexmin << " and " << dexmax<< "!";
			}
			else if(menu == 4){
				int failCount=0, itemCount=1, priceCount=0, counter=0;
				//unsigned suggestC=0;
				string searchItem, tmpItem;
				double percentSale;
				cout<<"\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n";
				cout<<"******* Merchant Calculator *******";
				cout<<"\nPlease enter the percent you are selling/buying at: ";
				Get(percentSale);
				cout<<"When you finish entering your items, simply type\n \"/end\" to return to the main menu.";
				double finalPrice = 0;
				while(searchItem!="/end"){
					cout<<"\nPlease enter item number " << itemCount << ": ";
					//				if(counter == 0){
					//					cin.ignore();
					//				}
					getline(cin, searchItem);
					if(searchItem=="/end"){
						break;
					}
					for(unsigned i = 0; i<=searchItem.length(); ++i){ //puts the input into lower case
						searchItem[i]=tolower(searchItem[i]);
					}
					for(int i = 1; i<maxItems; ++i){

						if(searchItem==items[i].n){
							priceCount=priceCount+items[i].p;
							itemCount++;
						}
						else{
							//							string testItem = items[i].n;
							//							for(unsigned i = 0; i <= testItem.length(); ++i){
							//								if(testItem.length()==searchItem.length()){
							//									cout<< testItem[i]<<" "<<searchItem[i]<<"\n";
							//
							//									if(testItem[i] == searchItem[i]){
							//										++suggestC;
							//										cout<<suggestC<<" "<<testItem.length()<<"\n";
							//										if(suggestC >= testItem.length()-2){
							//											suggestItem = testItem;
							//											break;
							//											cout<<"\n";
							//											suggestC=0;
							//										}
							//										else{
							//											//suggestC=0;
							//										}
							//									}
							//								}
							//							}
							failCount++;
							//cout<<suggestItem;
						}
					}
					if(failCount>=maxItems){
						cout<<"Sorry, I couldn't find that. Are you sure it is spelled correctly?\n";
						failCount =1;
					}
					finalPrice = priceCount*(percentSale/100);
					cout.precision(10);
					cout<<"Current Value: "<<finalPrice<<"\n";
					counter++;
					failCount=1;
				}
				menu=0;
			}
			else if(menu==5){
				double mAttk, pDef, mTotalAttk;
				cout<<"****** Monster Damage Calculator ******\n";
				cout<<"\nPlease note this is brand new and experimental, I would love \nsome feedback on how accurate it is so I can make adjustments if necessary.\nJust let me know in a quick post what the values you actually got were, \ncompared to the calculators predictions.";
				cout<<"\n\nEnter the attack power of the monster you are fighting: ";
				Get(mAttk);
				cout<<"Enter your defense: ";
				Get(pDef);
				mTotalAttk = (mAttk*1.6)-pDef;
				if(mTotalAttk>0){
					cout<<"This monster can do up to "<<mTotalAttk<<" damage to you.";
				}
				else{
					cout<<"This monster should not be able to damage you.";
				}
				menu=0;
			}
			else if(menu==6){
				double pDef, pAttk, weapon1, weapon2, hitPercent, modPercent;
				string clss;
				cout<<"****** Monster Fighting Guide ******";
				cout<<"\nThis gives you suggestions on what monsters you should \nbe fighting based on your class, defense, damage \nand monster strength.";
				cout<<"Enter your class (Cowboy, Archer, Mage or Warrior): ";
				cin>>clss;
				for(unsigned i = 0; i<=clss.length(); ++i){
					clss[i]=tolower(clss[i]);
				}
				while(clss!="archer"&&clss!="mage"&&clss!="warrior"&&clss!="cowboy"&&clss!="/end"){
					cout<<"I'm sorry, I didn't understand that.\nEnter your class: ";
					cin.clear();
					cin.ignore();
					cin>>clss;
				}
				if(clss=="/end"){
					throw ExitException();
				}
				cout<<"Enter your attack stat: ";
				Get(pAttk);
				cout<<"Enter your max damage value for your primary weapon: ";
				Get(weapon1);
				if(clss!="archer"&&clss!="cowboy"){
					cout<<"Enter your max damage value for your secondary weapon\n(Just enter 0 if you don't have a secondary): ";
					Get(weapon2);
				}
				cout<<"Enter your critical hit percentage: ";
				Get(hitPercent);
				cout<<"Enter your critical hit damage modifier percentage: ";
				Get(modPercent);
				cout<<"And finally, enter your defense: ";
				Get(pDef);
				int tAttk = pAttk*(weapon1+weapon2);

				for(unsigned i = 0; i<=clss.length(); ++i){
					clss[i]=tolower(clss[i]);
				}
				cout<<"Your ideal grinding monster(s) will be:\n";
				for(int i = 0; i<36; ++i){
					string tmpMonster;
					double critHit = (tAttk/monster[i].d)*(modPercent/100);
					if(clss=="warrior"&&pDef+20>=(monster[i].a)*1.6){
						if(hitPercent>=60&&critHit>monster[i].d&&critHit>=monster[i].h/8&&critHit<=monster[i].h/4){
							cout<<monster[i].cn<<"\n\n";

						}
						else if(hitPercent<50&&tAttk/monster[i].d>=monster[i].h/4&&tAttk/monster[i].d<=monster[i].h/2){
							cout<<monster[i].cn << "\n\n";
						}
					}
					else if(clss=="mage"){

						if(hitPercent>=50&&tAttk>=monster[i].d&&critHit>=monster[i].h/12&&critHit<=monster[i].h/5){
							cout<<monster[i].cn<<"\n\n";
						}
						else if(hitPercent<50&&tAttk/monster[i].d>=monster[i].h/8&&tAttk/monster[i].d<=monster[i].h/2){
							cout<<monster[i].cn << "\n\n";
						}
					}
					if(clss=="archer"){
						if(hitPercent>=50&&tAttk>=monster[i].d&&critHit>=monster[i].h/12&&critHit<=monster[i].h/2){
							cout<<monster[i].cn << "\n\n";
						}
						else if(hitPercent<50&&tAttk/monster[i].d>=monster[i].h/6&&tAttk/monster[i].d<=monster[i].h/2){
							cout<<monster[i].cn << "\n\n";
						}
					}
					if(clss=="cowboy"){
						if(hitPercent>=50&&tAttk>=monster[i].d&&critHit>=monster[i].h/9&&critHit<=monster[i].h/2){
							cout<<monster[i].cn << "\n\n";
						}
						else if(hitPercent<50&&tAttk/monster[i].d>=monster[i].h/11&&tAttk/monster[i].d<=monster[i].h/2){
							cout<<monster[i].cn << "\n\n";
						}
					}
					menu=0;
				}
				menu=0;
			}
			//		struct pet{
			//			int p, df, dx, c, h;
			//			string tp, ab1, ab2, ab3;
			//			pet(){}
			//			pet(int power, int health, int defense, int dexterity, int cost,
			//		string type, string ability1, string ability2, string ability3):
			//		p(power), h(health), df(defense), dx(dexterity), c(cost), tp(type), ab1(ability1), ab2(ability2), ab3(ability3){}

			else if(menu == 7){

				while(pMenu!=4){
					string sPet;
					int iTmp=0;
					int fCount = 0;
					cout<< "\n****** Pet Menu ******\n";
					cout<< "1. Pet Purchase Guide\n2. Pet Item Guide\n3. List Pet Names \n4. Back\n==> ";
					Get(pMenu);
					if(pMenu == 1){
						cout<< "*** Pet Purchase Guide ***\n";
						cout<<"Please note: For now this is first evolution out of the store purchases only.\nI am working on gathering the info on the other evolutions.";
						cout<<"Enter Pet name for information on it: ";
						cin>>sPet;

						for(unsigned i = 0; i<=sPet.length(); ++i){ //puts the input into lower case
							sPet[i]=tolower(sPet[i]);

						}
						for(int i = 1; i<21; i++){
							if(sPet==pets[i].tp){
								iTmp = i;
								cout<<"Name: "<< pets[iTmp].tp << "\nCost: "<< pets[iTmp].pc;
								cout<<"\nAbilities: "<< pets[iTmp].ab1 <<", "<< pets[iTmp].ab2 <<", " << pets[iTmp].ab3;
								cout<<"\nBase Stats:";
								cout<<"\nPower: "<<pets[iTmp].pp<< "      Defense: "<< pets[iTmp].pdf;
								cout<<"\nDexterity: "<<pets[iTmp].pdx<< "   Health: "<< pets[iTmp].ph;
								fCount = 0;
								break;
							}
							else if(fCount == 20){
								cout<<"\nI'm sorry I couldn't find that. Please check to make sure it is spelled correctly.\n";
								break;
							}
							else{
								fCount++;
							}
						}
					}
					else if(pMenu == 2){
						cout<<"\nComing soon. Will have boot and helmet special abilities for pets.\n";
					}
					else if(pMenu == 3){
						for(int i = 1; i < 21; i++){
							cout<<pets[i].tp <<"\n";
						}
					}
				}
				menu = 0;
			}
			else if(menu == 8){
				int searchOption = 0, failCount= 1, cI;
				string nm, s, p, cS;
				while(searchOption != 5){
					if(searchOption == 1){ //p,c,n,l price, class, name, location(shop)
						cout<< "*** Name Search ***";
						cout<<"\nItem name: ";
						getline(cin,nm);
						for(unsigned i = 0; i<nm.length(); ++i){ //puts the input into lower case
							nm[i]=tolower(nm[i]);
						}
						for(int i = 0; i<maxItems; i++){
							if(nm==items[i].n){
								cI = items[i].c;
								if(cI == 0){
									cS = "Multiple classes";
								}
								else if(cI == 1){
									cS = "Warriors";
								}
								else if(cI == 2){
									cS = "Mages";
								}
								else if(cI == 3){
									cS = "Archers";
								}
								else{
									cS = "Cowboys";
								}
								cout<< "Useful to: "<<cS<< "\nLocation: "<< items[i].l << "'s shop.\nPrice: "<< items[i].p<<"\n";
								failCount = 0;
								searchOption = 0;
							}
							else{
								failCount++;
							}
							if(failCount==maxItems){
								cout<<"Sorry, I couldn't find that. Are you sure it is spelled correctly?\n";
								failCount =1;
							}
						}
						searchOption = 0;
					}

					else if(searchOption == 2){
						cout<< "*** Shop Search ***";
						cout<<"\nShop: ";
						getline(cin,s);
						for(unsigned i = 0; i<s.length(); ++i){ //puts the input into lower case
							s[i]=tolower(s[i]);
						}
						for(int i = 0; i<maxItems; i++){
							if(s==items[i].l){
								cI = items[i].c;
								cout<< items[i].n<<"\n";
							}
							else{
								failCount++;
							}
							if(failCount>maxItems){
								cout<<"Sorry, I couldn't find any items for that shop. \nAvailable shops are:\n travis\n sam\n wallace\n chance\n tiberius\n snoop\n heath\n geraldo\n anoop\n carter\n sneed\n viper\n alpipa\n rita\n lewis\n ricardo\n val\n bartholemew\n";
								failCount =1;
							}
						}
						searchOption = 0;
					}

					else if(searchOption == 3){
						cout<< "*** Class Search ***\nNOTE: THIS WILL BE A BIG LIST,\nBE PREPARED TO SCROLL UP.";
						cout<<"\nClass: ";
						getline(cin,cS);
						if(cS == "/end"){
							searchOption = 0;
						}
						for(unsigned i = 0; i<=cS.length(); ++i){ //puts the input into lower case
							cS[i]=tolower(cS[i]);
						}
						if(cS == "special"){
							cI = 0;
						}
						else if(cS == "warrior"){
							cI = 1;
						}
						else if(cS == "mage"){
							cI = 2;
						}
						else if(cS == "archer"){
							cI = 3;
						}
						else if(cS == "cowboy"){
							cI = 4;
						}

						else{
							cout<<"Sorry, I don't think that class exists. \nAvailable classes are: \n Special \n Warrior \n Mage \n Archer\n Cowboy\n";
							searchOption = 0;
							cI=5;
						}
						for(int i = 0; i<maxItems; i++){
							if(items[i].c==cI){
								cout<< items[i].n<<"\n";
							}
						}
						searchOption = 0;
					}

					else if(searchOption == 4){
						long pH, pL;
						string tmp;
						cout<<"*** Price Search ***\n";
						cout<<"NOTE: DEPENDING ON HOW LARGE YOUR RANGE IS,\nTHIS LIST COULD BE VERY LONG.\n";
						cout<<"Enter your lower price range: ";
						Get(pL);
						cout<<"Enter your upper price range: ";
						Get(pH);
						cout<<"Item(s) in that price range: \n";
						for(int i = 0; i<maxItems; i++){
							if(items[i].p>=pL&&items[i].p<= pH){
								tmp=items[i].n;
								cout<<tmp<<"\n";
							}
						}
						searchOption = 0;
					}

					else{
						cout<<"\n*** Catalog Search ***";
						cout<<"\nSearch by:\n 1. Name\n 2. Shop\n 3. Class\n 4. Price\n 5. Back\n  ==>";
						Get(searchOption);
					}
				}
				menu = 0;
			}

			else if(menu == 9){
				string SACl; //Stat Allocation Class
				int tsp;
				cout<<"\n*** Stat Allocation Guide ***";
				cout<<"\nThis guide can be used most effectively following a stat reset \n(purchased from Payvault) Please note that special skill points are not in this guide\nHopefully in the future I will be able to add another guide for them.";
				cout<<"\n\nEnter your class (Archer, Cowboy, Mage or Warrior): ";
				cin>>SACl;

				for(unsigned i = 0; i<=SACl.length(); ++i){
					SACl[i]=tolower(SACl[i]);
				}

				while(SACl!="archer"&&SACl!="mage"&&SACl!="warrior"&&SACl!="cowboy"&&SACl!="/end"){
					cout<<"I'm sorry, I didn't understand that.\nEnter your class: ";
					cin.clear();
					cin.ignore();
					cin>>SACl;
				}
				if(SACl=="/end"){
					throw ExitException();
				}
				cout<<"\n(NOTE: if not done immediately following a stat reset please subtract your armor/pet bonus and add up your numbers that way\nthis can then serve as a long term suggestion to what you should be aiming for)\n\nEnter your total stat points: ";
				Get(tsp);
				//				cout<<"Enter your total special skill points: ";
				//				Get(tskp);
				int pofsa, pofsdf, pofsdx, pofsh, pofsmp, hpofsa, hpofsdf, hpofsdx, hpofsh, hpofsmp;//percentage of stats to attack, defense, dexterity, health and mp Then "high" versions of previous.
				int alla, alldf, alldx, allh, allmp;
				char trig;
				if(SACl == "warrior"){
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
						pofsdf = 25;
						pofsdx = 30;
						pofsh = 0;
						pofsmp = 5;

						trig = 'l';
					}
					else if(tsp<3000&&tsp>1000){
						hpofsa = 60;
						hpofsdf = 40;
						hpofsdx = 0;
						hpofsh = 0;
						hpofsmp = 0;

						trig = 'h';
					}
					else if(tsp<6000&&tsp>3000){
						hpofsa = 70;
						hpofsdf = 30;
						hpofsdx = 0;
						hpofsh = 0;
						hpofsmp = 0;

						trig = 'h';
					}
					else if(tsp>6000){
						hpofsa = 80;
						hpofsdf = 20;
						hpofsdx = 0;
						hpofsh = 0;
						hpofsmp = 0;

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
						allh = 50;
						allmp = 50;
					}
				}
				else if(SACl == "mage"){
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
						hpofsdx = 0;
						hpofsh = 0;
						hpofsmp = 15;

						trig = 'h';
					}
					else if(tsp<6000&&tsp>3000){
						hpofsa = 60;
						hpofsdf = 20;
						hpofsdx = 0;
						hpofsh = 0;
						hpofsmp = 20;

						trig = 'h';
					}
					else if(tsp>6000){
						hpofsa = 65;
						hpofsdf = 15;
						hpofsdx = 0;
						hpofsh = 0;
						hpofsmp = 20;

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
						allh = 80;
						allmp = (tsp*hpofsmp)/100;
					}
				}
				else if(SACl == "archer"){
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
						hpofsdx = 0;
						hpofsh = 0;
						hpofsmp = 10;

						trig = 'h';
					}
					else if(tsp<6000&&tsp>3000){
						hpofsa = 80;
						hpofsdf = 10;
						hpofsdx = 0;
						hpofsh = 0;
						hpofsmp = 10;

						trig = 'h';
					}
					else if(tsp>6000){
						hpofsa = 80;
						hpofsdf = 10;
						hpofsdx = 0;
						hpofsh = 0;
						hpofsmp = 10;

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
						allh = 80;
						allmp = (tsp*hpofsmp)/100;
					}
				}
				else if(SACl == "cowboy"){
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
						hpofsdx = 0;
						hpofsh = 0;
						hpofsmp = 10;

						trig = 'h';
					}
					else if(tsp<6000&&tsp>3000){
						hpofsa = 70;
						hpofsdf = 20;
						hpofsdx = 0;
						hpofsh = 0;
						hpofsmp = 10;

						trig = 'h';
					}
					else if(tsp>6000){
						hpofsa = 70;
						hpofsdf = 15;
						hpofsdx = 0;
						hpofsh = 0;
						hpofsmp = 15;

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
						allh = 80;
						allmp = (tsp*hpofsmp)/100;
					}
				}
				cout<<"Allocation of stats should go as follows ==>\n"<<"Attack: "<< alla <<"\nDefense: "<<alldf<<"\nDexterity: "<<alldx<<"\nHealth: "<<allh<<"\nMP: "<<allmp;
				menu=0;
			}

			else if(menu == 10){
				cout<< "*** Fishing Guide (coming soon) ***";
				menu = 0;
			}
			else{
				menu=0;
				cout << "\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n \n";
				cout << "Select a menu option by pressing its corresponding number:\n";
				cout << "1. Level-Experience Calculator (v1.2)\n2. Guide of Items by Level (v4.0)\n3. Damage Calculator (v1.7)\n4. Merchant Calculator (v2.5)\n5. Monster Damage Calculator (v2.6)\n6. Monster Fighting Guide (v3.1)\n7. Pet Menu (1.2)\n8. Search (2.0) \n9. Stat Allocation Guide (1.1)\n10. Fishing Guide *(Coming Soon)*\n*Enter a number greater than 10 to exit.*\n==> ";
				Get(menu);
			}
		}
		catch(ExitException &){
			menu=0;
		}

	}
	return 0;
}
