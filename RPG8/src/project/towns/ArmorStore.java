package project.towns;

import java.util.ArrayList;

import project.items.ItemResources;

public class ArmorStore implements StoreInterface{

	int money;
	ArrayList<ShopItems> itemListA = new ArrayList<ShopItems>(){{add((ShopItems) ItemResources.rifles1GradeC1); add((ShopItems) ItemResources.rifles3GradeA2); add((ShopItems) ItemResources.rifles4GradeA3); add((ShopItems) ItemResources.pistol2GradeB1);}};
	ArrayList<Integer> itemNA = new ArrayList<Integer>();
	public ArmorStore(ArrayList<Integer> itemN, int money) {
		this.money = money;
		for(int i = 0; i  < 3; i++){
			itemNA.add(i, 0);
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public void moneyInteraction(int itemx) {
		// TODO Auto-generated method stub
		if(itemx == 92)
			if(money >= 450){
					itemNA.set(0, itemNA.get(0) + 1);
					money = money - 450;
				}
			if(itemx == 192)
				if(money >= 350){
					itemNA.set(1,itemNA.get(1) + 1);
					money -= 350;
				}
			if(itemx == 292)
				if(money >= 250){
					itemNA.set(2, itemNA.get(2) + 1);
					money -= 250;
				}
	}

	@Override
	public void moneySellingInteraction(int itemx) {
		// TODO Auto-generated method stub
		if(itemx == 92){
			if(itemNA.get(0) > 0){
				itemNA.set(0, itemNA.get(0) - 1);
				money = money + 450;
			}
		}
		if(itemx == 192){
			if(itemNA.get(1) > 0){
				itemNA.set(1, itemNA.get(1) - 1);
				money = money + 350;
			}
		}
		if(itemx == 292){
			if(itemNA.get(2) > 0){
				itemNA.set(2, itemNA.get(2) - 1);
				money = money + 250;
			}
		}
	}
	public void AllInteraction(int itemx) {
		// TODO Auto-generated method stub
		if(itemx == 92)
		if(money >= 450){
				money = money - 450;
			}
		if(itemx == 192)
			if(money >= 350){
				money -= 350;
			}
		if(itemx == 292)
			if(money >= 250){
				money -= 250;
			}
		if(itemx == 392)
			if(money >= 250){
				money -= 150;
			}
		}

	public void AllSellingInteraction(int itemx) {
		// TODO Auto-generated method stub
		if(itemx == 92){
			if(itemNA.get(0) > 0){
				money = money + 450;
			}
		}
		if(itemx == 192){
			if(itemNA.get(1) > 0){
				money = money + 350;
			}
		}
		if(itemx == 292){
			if(itemNA.get(2) > 0){
				money = money + 250;
			}
		}
		if(itemx == 392){
			if(itemNA.get(2) > 0){
				money = money + 150;
			}
		}
	}
	@Override
	public void itemSellingInteraction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemInteraction() {
		// TODO Auto-generated method stub
		
	}

	public void setMoney(int money) {
		this.money = money;
	}

}
