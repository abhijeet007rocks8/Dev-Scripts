//////////////<<<<<<<<<<<<<<<<    Admin Department Code Here     >>>>>>>>>>>>///////////////////

#include"Faculty_Portal.h"

class Admin: public Library{
	private:
		node *temp, *temp1;
	public:
		int id, age, n;
		string name, phone_no,cnic, fatherName, gmail, address, gender, latest_qualification, post, status, campuss;
		node *root6;
		Admin()
		{
			root6 = NULL;
		}
};
