import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Event
	{
	public static void generateEvent()
		{
		int situationNum = (int) (Math.random() * 10) + 1;
		
		switch(situationNum)
			{	
			case 1:
				{
				watcherInTheWater();
				break;
				}
			case 2:
				{
				betOnGladiatorFight();
				break;
				}
			case 3:
				{
				pickpocketed();
				break;
				}
			case 4:
				{
				
				break;
				}
			case 5:
				{
				
				break;
				}	
			case 6:
				{
				
				break;
				}
			case 7:
				{
				
				break;
				}
			case 8:
				{
				
				break;
				}
			case 9:
				{
				
				break;
				}
			case 10:
				{
				
				break;
				}	
				
			}
		}
	
	public static void watcherInTheWater()
		{
		JFrame frame = new JFrame();
		ImageIcon icon = new ImageIcon(("watcher.jpg"));
		ImageIcon icon2 = new ImageIcon(("bridge.jpg"));
		ImageIcon icon3 = new ImageIcon(("river.jpg"));
		
		JOptionPane.showMessageDialog(frame, "On your travels you come across a sturdy bridge crossing a fast river.",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon2);
		JOptionPane.showMessageDialog(frame, "You are halfway across the bridge when you notice something...",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon2);
		JOptionPane.showMessageDialog(frame, "Tentacles are rising from the water and are fast approaching the bridge!",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		Object[] choose = {"Run across the bridge", "Leave and try to ford the river somewhere else", "Drive the creature back with magic"};
		int choice = JOptionPane.showOptionDialog(frame, "What would you like to do?",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				icon, choose, choose[0]);
		
		switch(choice)
			{
			case 0:
				{
				JOptionPane.showMessageDialog(frame, "You brace yourself and charge across the bridge.",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				int chance = (int) (Math.random() * 10);
				if(chance > Hero.heroes.get(0).getAgilityLevel())
					{
					JOptionPane.showMessageDialog(frame, "Unfortunately you are not fast enough and a tentacle slices through your armor as you run by.",
							"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
							JOptionPane.QUESTION_MESSAGE,
							icon);
					JOptionPane.showMessageDialog(frame, "You lose 5 max health!",
							"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
							JOptionPane.QUESTION_MESSAGE,
							icon);
					Hero.heroes.get(0).setHeroHP(Hero.heroes.get(0).getHeroHP() - 5);
					Hero.heroes.get(0).setMaxHeroHP(Hero.heroes.get(0).getMaxHeroHP() - 5);
					}
				else
					{
					JOptionPane.showMessageDialog(frame, "You speed across the bridge and dodge the incoming tentacles.",
							"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
							JOptionPane.QUESTION_MESSAGE,
							icon);
					JOptionPane.showMessageDialog(frame, "Your agility increases!",
							"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
							JOptionPane.QUESTION_MESSAGE,
							icon);
					Hero.heroes.get(0).setAgilityLevel(Hero.heroes.get(0).getAgilityLevel() + 2);
					}
				break;
				}
			case 1:
				{
				JOptionPane.showMessageDialog(frame, "You retreat from the bridge and search the river for another opportunity.",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);	
				JOptionPane.showMessageDialog(frame, "The river is dangerous but you find an okay spot and attempt to cross nevertheless.",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon3);	
				int chance = (int) (Math.random() * 10);
				if(chance > Hero.heroes.get(0).getStrengthLevel())
					{
					JOptionPane.showMessageDialog(frame, "The current is too much for you and you lose most of your gear!",
							"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
							JOptionPane.QUESTION_MESSAGE,
							icon3);	
					Hero.heroInventory.set(0, new Sword("Fists", 0, 2, true));
					Hero.heroInventory.set(1, new LightArmor("Rags", 0, "Light", 0, true));
					if(Hero.heroInventory.get(3) instanceof Potion)
						{
						Potion potion = (Potion) Hero.heroInventory.get(3);
						potion.setFull(false);
						potion.setItemName("Empty Potion");
						}
					}
				else
					{
					JOptionPane.showMessageDialog(frame, "The crossing is a success! You even find something at the bottom of the river along the way.",
							"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
							JOptionPane.QUESTION_MESSAGE,
							icon3);	
					Hero.openLoot();
					}
				break;	
				}
			case 2:
				{
				JOptionPane.showMessageDialog(frame, "You begin to chant a powerful spell.",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				int chance = (int) (Math.random() * 10);
				if(chance > Hero.heroes.get(0).getMagicLevel())
					{
					JOptionPane.showMessageDialog(frame, "The spell backfires throwing you across the river but injuring you badly.",
							"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
							JOptionPane.QUESTION_MESSAGE,
							icon);	
					JOptionPane.showMessageDialog(frame, "You lose 5 max health!",
							"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
							JOptionPane.QUESTION_MESSAGE,
							icon);
					Hero.heroes.get(0).setHeroHP(Hero.heroes.get(0).getHeroHP() - 5);
					Hero.heroes.get(0).setMaxHeroHP(Hero.heroes.get(0).getMaxHeroHP() - 5);
					}
				else
					{
					JOptionPane.showMessageDialog(frame, "The spell explodes towards the creature throwing it out of the water off a cliff.",
							"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
							JOptionPane.QUESTION_MESSAGE,
							icon);
					JOptionPane.showMessageDialog(frame, "Your magic increases!",
							"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
							JOptionPane.QUESTION_MESSAGE,
							icon);
					Hero.heroes.get(0).setMagicLevel(Hero.heroes.get(0).getMagicLevel() + 2);	
					}
				break;	
				}
			}
		}
	
	public static void betOnGladiatorFight()
		{
		JFrame frame = new JFrame();
		ImageIcon icon = new ImageIcon(("gladiators2.jpg"));
		ImageIcon icon2 = new ImageIcon(("arena.jpg"));
		ImageIcon icon3 = new ImageIcon(("gold coins.jpg"));
		ImageIcon blue = new ImageIcon(("blue flag.jpg"));
		ImageIcon red = new ImageIcon(("red flag.jpg"));
		
		JOptionPane.showMessageDialog(frame, "On your travels you come across an massive stone structure.",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon2);
		JOptionPane.showMessageDialog(frame, "It is an arena!",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon2);
		JOptionPane.showMessageDialog(frame, "As you walk through the doors you hear that two fighters are about to duel.",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon2);
		JOptionPane.showMessageDialog(frame, "A fighter with heavy armor and a claymore from the red team is facing off against a learned battlemage from the blue team.",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon);
		Object[] chooseOne = {"Bet", "Leave"};
		int choiceOne = JOptionPane.showOptionDialog(frame, "Luckily, betting is still open!  Would you like to bet?",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				icon3, chooseOne, chooseOne[0]);
		
		switch(choiceOne)
			{
			case 0:
				{
				Object[] chooseChampion = {"The Red Fighter", "The Blue Mage"};
				int champion = JOptionPane.showOptionDialog(frame, "Who would you like to bet on?",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						icon3, chooseChampion, chooseChampion[0]);
				
				Object[] chooseBet = {"Your Weapon", "Your Armor", "Your Potion"};
				int bet = JOptionPane.showOptionDialog(frame, "What would you like to bet?",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						icon3, chooseBet, chooseBet[0]);
				
				int winningGladiator = (int) (Math.random() * 2) + 1;
				
				JOptionPane.showMessageDialog(frame, "You enter the stands just as the fight begins.",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				
				JOptionPane.showMessageDialog(frame, "The gladiators circle eachother, feeling out the other fighter's skills.",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				
				JOptionPane.showMessageDialog(frame, "Suddenly, there is a clash of steel and magic raising a cloud of dust.",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				
				JOptionPane.showMessageDialog(frame, "The dust clears and you see that there is only one fighter remaining.",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);
				
				switch(winningGladiator)
					{
					case 1:
						{
						JOptionPane.showMessageDialog(frame, "The red fighter is the voctor!",
								"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
								JOptionPane.QUESTION_MESSAGE,
								red);	
						
						if(champion == 0)
							{
							JOptionPane.showMessageDialog(frame, "You bet correctly and have earned your prize.",
									"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
									JOptionPane.QUESTION_MESSAGE,
									icon3);		
							Hero.openLoot();	
							Hero.openLoot();
							}
						else
							{
							JOptionPane.showMessageDialog(frame, "You lost the bet!",
									"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
									JOptionPane.QUESTION_MESSAGE,
									icon3);		
							if(bet == 0)
								{
								Hero.heroInventory.set(0, new Sword("Fists", 0, 2, true));
								}
							else if(bet == 1)
								{
								Hero.heroInventory.set(1, new LightArmor("Rags", 0, "Light", 0, true));	
								}
							else
								{
								if(Hero.heroInventory.get(3) instanceof Potion)
									{
									Potion potion = (Potion) Hero.heroInventory.get(3);
									potion.setFull(false);
									potion.setItemName("Empty Potion");
									}
								}
							}
						break;
						}
					case 2:
						{
						JOptionPane.showMessageDialog(frame, "The blue mage is the victor!",
								"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
								JOptionPane.QUESTION_MESSAGE,
								blue);		
						if(champion == 1)
							{
							JOptionPane.showMessageDialog(frame, "You bet correctly and have earned your prize.",
									"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
									JOptionPane.QUESTION_MESSAGE,
									icon3);		
							Hero.openLoot();	
							Hero.openLoot();
							}
						else
							{
							JOptionPane.showMessageDialog(frame, "You lost the bet!",
									"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
									JOptionPane.QUESTION_MESSAGE,
									icon3);		
							if(bet == 0)
								{
								Hero.heroInventory.set(0, new Sword("Fists", 0, 2, true));
								}
							else if(bet == 1)
								{
								Hero.heroInventory.set(1, new LightArmor("Rags", 0, "Light", 0, true));	
								}
							else
								{
								if(Hero.heroInventory.get(3) instanceof Potion)
									{
									Potion potion = (Potion) Hero.heroInventory.get(3);
									potion.setFull(false);
									potion.setItemName("Empty Potion");
									}
								}
							}
						break;
						}
					}
						
				break;
				}
			case 1:
				{
				JOptionPane.showMessageDialog(frame, "You have never really enjoyed gambling, so you decide to leave.",
						"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
						JOptionPane.QUESTION_MESSAGE,
						icon);	
				break;
				}
			}
		}
	
	public static void pickpocketed()
		{
		JFrame frame = new JFrame();
		ImageIcon icon = new ImageIcon(("steps.png"));
		ImageIcon icon2 = new ImageIcon(("pickpocket.jpg"));
		
		JOptionPane.showMessageDialog(frame, "While you are walking down the path you pass a young man in a cloak.",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon2);	
		JOptionPane.showMessageDialog(frame, "He accidentally bumps into you and apoligizes.",
				"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
				JOptionPane.QUESTION_MESSAGE,
				icon2);	
		
		int chance = (int) (Math.random() * 10);
		if(chance < Hero.heroes.get(0).getAgilityLevel())
			{
			JOptionPane.showMessageDialog(frame, "Luckily you realize that he has stolen your equipment and you force him to return the goods!",
					"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
					JOptionPane.QUESTION_MESSAGE,
					icon2);	
			JOptionPane.showMessageDialog(frame, "You learn from this experience becoming even more agile!",
					"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
					JOptionPane.QUESTION_MESSAGE,
					icon2);	
			Hero.heroes.get(0).setAgilityLevel(Hero.heroes.get(0).getAgilityLevel() + 2);
			}
		else
			{
			JOptionPane.showMessageDialog(frame, "You assure him that it's fine and continue on your way.",
					"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
					JOptionPane.QUESTION_MESSAGE,
					icon2);	
			JOptionPane.showMessageDialog(frame, "You only later realize that he stole your weapon and your potion!",
					"" + Hero.heroes.get(0).getName() + "'s HP = " + Hero.heroes.get(0).getHeroHP() + "/" + Hero.heroes.get(0).getMaxHeroHP() + "",
					JOptionPane.QUESTION_MESSAGE,
					icon2);	
			Hero.heroInventory.set(0, new Sword("Fists", 0, 2, true));
			if(Hero.heroInventory.get(3) instanceof Potion)
				{
				Potion potion = (Potion) Hero.heroInventory.get(3);
				potion.setFull(false);
				potion.setItemName("Empty Potion");
				}
			}
		}
	}