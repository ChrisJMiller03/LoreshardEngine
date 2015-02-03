import java.util.ArrayList; 

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Hero extends Creature
	{
	private int heroHP;
	private int adrenaline;
	private int overAllLevel;
	private int magicLevel;
	private int agilityLevel;
	private int strengthLevel;
	private int speechLevel;
	private String characterClass;
	static ArrayList <Hero> heroes = new ArrayList<Hero>();
	static ArrayList <Item> heroInventory = new ArrayList<Item>();
	
	
	public Hero(String n, int h, int ad, int o, int m, int ag, int st, int sp, String c)
		{
		setName(n);
		heroHP = h;
		adrenaline = ad;
		overAllLevel = o;
		magicLevel = m;
		agilityLevel = ag;
		strengthLevel = st;
		speechLevel = sp;
		characterClass = c;
		}
	
	
	public static void chooseAttack(int monsterNum)
		{
		int weaponNumber;
		int CombatChoice;
		int damage = 2;
		JFrame frame = new JFrame();
		
		Object[] combatType = {"Melee", "Magic", "Scroll"};
		CombatChoice = JOptionPane.showOptionDialog(frame, "What would you like to do?",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null, combatType, combatType[1]);
		switch(CombatChoice)
			{
			case 0:
				{
				if(Hero.heroInventory.get(0) instanceof Weapon)
					{
					Weapon weapon = (Weapon) Hero.heroInventory.get(0);
					damage = weapon.getDamage();
					}
				attack(Monster.monsters.get(monsterNum).getHitPoints(), Monster.monsters.get(monsterNum).getMonsterDamage(), 3, Hero.heroes.get(0).getHeroHP(), Hero.heroes.get(0).getStrengthLevel(), monsterNum);
				break;
				}
			case 1:
				{
				Magic.castMagic(Monster.monsters.get(monsterNum).getHitPoints(), Hero.heroes.get(0).getMagicLevel(), monsterNum);
				break;
				}
			case 2:
				{
				
				break;
				}
			}
		continueBattle(monsterNum);
		}

	public static void attack(int hitPoints, int damage, int monsterDamage, int heroHP, int strengthLevel, int monsterNum)
		{	
		int meleeChoice;
		damage = (int) (Math.random() * (damage + strengthLevel)) + strengthLevel;
		JFrame frame = new JFrame();
		
		Object[] attackType = {"High", "Medium", "Low"};
		meleeChoice = JOptionPane.showOptionDialog(frame, "Where would you like to strike?",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + heroHP + "",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null, attackType, attackType[1]);
		
		checkForCrit(damage);
		
		switch(meleeChoice)
			{
			case 0:
				{
				damage = damage + (strengthLevel * 2);
				JOptionPane.showMessageDialog(frame, "You attack high and do " + damage + " damage to the monster!",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + heroHP + "",
						JOptionPane.QUESTION_MESSAGE);	
				hitPoints = hitPoints - damage;
				JOptionPane.showMessageDialog(frame, "The monster has " + hitPoints + " HP left!",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + heroHP + "",
						JOptionPane.QUESTION_MESSAGE);		
				break;
				}
			case 1:
				{
				damage = damage + strengthLevel;
				JOptionPane.showMessageDialog(frame, "You attack mid and do " + damage + " damage to the monster!",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + heroHP + "",
						JOptionPane.QUESTION_MESSAGE);	
				hitPoints = hitPoints - damage;
				JOptionPane.showMessageDialog(frame, "The monster has " + hitPoints + " HP left!",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + heroHP + "",
						JOptionPane.QUESTION_MESSAGE);	
				break;
				}
			case 2:
				{
				JOptionPane.showMessageDialog(frame, "You attack low and do " + damage + " damage to the monster!",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + heroHP + "",
						JOptionPane.QUESTION_MESSAGE);			
				hitPoints = hitPoints - damage;
				JOptionPane.showMessageDialog(frame, "The monster has " + hitPoints + " HP left!",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + heroHP + "",
						JOptionPane.QUESTION_MESSAGE);	
				break;
				}
			}
		Monster.monsters.get(monsterNum).setHitPoints(hitPoints);
		}
	
	public static void checkForCrit(int damage)
		{
		int chance = (int) (Math.random() * 100) + 1;
		JFrame frame = new JFrame();
				
		if(chance <= 5)
			{
			JOptionPane.showMessageDialog(frame, "CRITICAL HIT, 2x DAMAGE!",
					"CRITICAL HIT",
					JOptionPane.QUESTION_MESSAGE);
			damage = damage * 2;
			}
		}
	
	public void defend()
		{
		//nothing yet
		}
	
	public static void continueBattle(int monsterNum)
		{
		JFrame frame = new JFrame();
		
		if(Monster.monsters.get(monsterNum).getHitPoints() <= 0)
			{
			JOptionPane.showMessageDialog(frame, "You have defeated the monster!",
					"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "",
					JOptionPane.QUESTION_MESSAGE);
			Item loot = Hero.openLoot();
			if(Hero.heroInventory.size() > 0)
				{
				if(loot instanceof Weapon && Hero.heroInventory.get(0) instanceof Weapon)
					{
					Weapon oldWeapon = (Weapon) Hero.heroInventory.get(0);
					int oldDamage = oldWeapon.getDamage();
					
					Weapon newWeapon = (Weapon) loot;
					int newDamage = newWeapon.getDamage();
					if(newDamage > oldDamage)
						{
						Hero.heroInventory.set(0, loot);
						}
					}
				if(loot instanceof Armor && Hero.heroInventory.get(0) instanceof Armor)
					{
					Armor oldArmor = (Armor) Hero.heroInventory.get(0);
					int oldAC = oldArmor.getArmorLevel();
					
					Armor newArmor = (Armor) loot;
					int newAC = newArmor.getArmorLevel();
					if(newAC > oldAC)
						{
						Hero.heroInventory.set(1, loot);
						}
					}
				}
			
			showInventory(Hero.heroInventory.get(0).getItemName(), Hero.heroInventory.get(1).getItemName());
			Hero.levelUp(Hero.heroes.get(0).getHeroHP(), Hero.heroes.get(0).getAdrenaline(), Hero.heroes.get(0).getOverAllLevel(), Hero.heroes.get(0).getMagicLevel(), Hero.heroes.get(0).getAgilityLevel(), Hero.heroes.get(0).getStrengthLevel(), Hero.heroes.get(0).getSpeechLevel());
			if(Monster.monsters.size() <= 0)
				{
				JOptionPane.showMessageDialog(frame, "As the last of your foes falls to the ground the crowd cheers!",
						"",
						JOptionPane.QUESTION_MESSAGE);
				JOptionPane.showMessageDialog(frame, "You have beaten the arena, and are free to leave.",
						"",
						JOptionPane.QUESTION_MESSAGE);
				JOptionPane.showMessageDialog(frame, "You walk through the gates of the arena into a land of danger.",
						"",
						JOptionPane.QUESTION_MESSAGE);
				JOptionPane.showMessageDialog(frame, "Adventure awaits.",
						"",
						JOptionPane.QUESTION_MESSAGE);
				System.exit(0);
				}
			}
		else
			{
			Monster.attack(Monster.monsters.get(monsterNum).getHitPoints(), Monster.monsters.get(monsterNum).getMonsterDamage(), 3, Hero.heroes.get(0).getHeroHP(), Hero.heroes.get(0).getStrengthLevel(), monsterNum);
			}
		}
	
	public static Item openLoot()
		{
		int lootNumber = (int) (Math.random() * Item.items.size());
		JFrame frame = new JFrame();
		
		JOptionPane.showMessageDialog(frame, "You found: " + Item.items.get(lootNumber).getItemName() + "!",
				"LOOTING",
				JOptionPane.QUESTION_MESSAGE);
		Item.items.get(lootNumber).setIsEquipped(true);
		return Item.items.get(lootNumber);
		}
	
	public static void showInventory(String weapon, String armor)
		{
		JFrame frame = new JFrame();
		
		JOptionPane.showMessageDialog(frame, "WEAPON: " + weapon + "\n ARMOR: " + armor + "",
				"INVENTORY",
				JOptionPane.QUESTION_MESSAGE);
		}
	
	public static void levelUp(int heroHP, int adrenaline, int overAllLevel, int magicLevel, int agilityLevel, int strengthLevel, int speechLevel)
		{
		int levelUpChoice;
		JFrame frame = new JFrame();
		
		Object[] level = {"Magic", "Agility", "Strength", "Speech"};
		levelUpChoice = JOptionPane.showOptionDialog(frame, "What would you like to level up in?",
				"LEVEL UP: " + overAllLevel + " > " + (overAllLevel + 1) + "",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null, level, level[1]);
		
		overAllLevel++;
		Hero.heroes.get(0).setOverAllLevel(overAllLevel);
		heroHP = heroHP + (10 * strengthLevel);
		Hero.heroes.get(0).setHeroHP(heroHP);
		switch(levelUpChoice)
			{
			case 0:
				{
				magicLevel++;
				JOptionPane.showMessageDialog(frame, "You have leveled up in Magic!",
						"Magic: " + (magicLevel - 1) + " > " + magicLevel + "",
						JOptionPane.QUESTION_MESSAGE);
				Hero.heroes.get(0).setMagicLevel(magicLevel);
				break;
				}
			case 1:
				{
				agilityLevel++;
				JOptionPane.showMessageDialog(frame, "You have leveled up in Agility!",
						"Agility: " + (agilityLevel - 1) + " > " + agilityLevel + "",
						JOptionPane.QUESTION_MESSAGE);
				Hero.heroes.get(0).setAgilityLevel(agilityLevel);
				break;
				}
			case 2:
				{
				strengthLevel++;
				JOptionPane.showMessageDialog(frame, "You have leveled up in Strength!",
						"Strength: " + (strengthLevel - 1) + " > " + strengthLevel + "",
						JOptionPane.QUESTION_MESSAGE);
				Hero.heroes.get(0).setStrengthLevel(strengthLevel);
				break;
				}
			case 3:
				{
				speechLevel++;
				JOptionPane.showMessageDialog(frame, "You have leveled up in Charisma!",
						"Speech"
						+ ": " + (speechLevel - 1) + " > " + speechLevel + "",
						JOptionPane.QUESTION_MESSAGE);
				Hero.heroes.get(0).setSpeechLevel(speechLevel);
				break;
				}
			}
		}
	
	//also add:
	//buy/sell method
	//potion craft method
	//enhance attack method


	public int getHeroHP()
		{
		return heroHP;
		}


	public void setHeroHP(int heroHP)
		{
		this.heroHP = heroHP;
		}


	public int getAdrenaline()
		{
		return adrenaline;
		}


	public void setAdrenaline(int adrenaline)
		{
		this.adrenaline = adrenaline;
		}


	public int getOverAllLevel()
		{
		return overAllLevel;
		}


	public void setOverAllLevel(int overAllLevel)
		{
		this.overAllLevel = overAllLevel;
		}


	public int getMagicLevel()
		{
		return magicLevel;
		}


	public void setMagicLevel(int magicLevel)
		{
		this.magicLevel = magicLevel;
		}


	public int getAgilityLevel()
		{
		return agilityLevel;
		}


	public void setAgilityLevel(int agilityLevel)
		{
		this.agilityLevel = agilityLevel;
		}


	public int getStrengthLevel()
		{
		return strengthLevel;
		}


	public void setStrengthLevel(int strengthLevel)
		{
		this.strengthLevel = strengthLevel;
		}


	public int getSpeechLevel()
		{
		return speechLevel;
		}


	public void setSpeechLevel(int speechLevel)
		{
		this.speechLevel = speechLevel;
		}


	public String getCharacterClass()
		{
		return characterClass;
		}


	public void setCharacterClass(String characterClass)
		{
		this.characterClass = characterClass;
		}


	public static ArrayList<Item> getInventory()
		{
		return heroInventory;
		}


	public static void setInventory(ArrayList<Item> inventory)
		{
		Hero.heroInventory = inventory;
		}
	
	
	}
