package com.example.tuckerfooddelivery.View.Items

import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tuckerfooddelivery.Model.Add.addCart
import com.example.tuckerfooddelivery.Model.Add.addWishlist
import com.example.tuckerfooddelivery.R
import com.example.tuckerfooddelivery.View.Profile.CircularButtonWithSymbol

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ClassicFrenchFries(navController: NavController) {
    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
//    var  Fries_image: Any = Image(
//       painter = painterResource(id = R.drawable.classic_french_fries),
//       contentDescription = "Pizza",
//       modifier = Modifier
//           .padding(100.dp)
////            .align(Alignment.Center)
//           .size(100.dp) )
    var selectedButtonIndex by remember { mutableStateOf(1) }

    @Composable
    fun getButtonColor(index: Int): Color {
        return if (index == selectedButtonIndex) Mustard_yellow else colorResource(id = R.color.White_Blue)
    }

    fun onButtonClick(index: Int) {
        selectedButtonIndex = index
    }
    var totalprice: Int by remember { mutableStateOf(39) }
    val unitPriceRegular: Int by remember { mutableIntStateOf(39) }
    val unitPriceLarge: Int by remember { mutableStateOf(50) }
    var size by remember { mutableStateOf("Regular") }
    val Item_Name = "ClassicFrenchFries"
    val Name = "Classic French Fries"

    var count by remember {
        mutableStateOf<Int>(1)
    }
    val context = LocalContext.current

    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)
    Column(
        Modifier
            .fillMaxSize()
            .padding(0.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            modifier = Modifier
                .padding(horizontal =10.dp)
                .background(White)
                .fillMaxHeight(.9f)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            //Jaggu
            Row(verticalAlignment = Alignment.CenterVertically) {
                CircularButtonWithSymbol {
                    navController.popBackStack()
                }
                Spacer(modifier = Modifier.width(1.dp))
                Text(
                    text = "Details",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }
                Spacer(modifier = Modifier.height(10.dp))
                Card(
                    shape = RoundedCornerShape(16.dp),
                    backgroundColor = Mustard_yellow,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .wrapContentHeight(),
                ) {
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.classic_french_fries),
                            contentDescription = "classic_french_fries",
                            modifier = Modifier
                                .align(Alignment.Center)
                                .size(260.dp)
                        )
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Add",
                            tint = Color.White,
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .size(40.dp)
                                .background(Color.Red, shape = CircleShape)
                                .padding(8.dp)
                                .clickable {
                                    if(totalprice == unitPriceRegular)size = "Regular" else size = "Large"
                                    addWishlist(Item_Name,totalprice ,count,size)
                                }

                        )
                    }
                }
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = Name,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 15.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Crunch into perfection with our classic salted French fries. Golden and crispy on the outside, soft and fluffy on the inside.",
                fontSize = 18.sp,
                modifier = Modifier.padding(horizontal = 15.dp)
            )
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.star__),
                    contentDescription = "Pizza",
                    modifier = Modifier
                        //.align(Alignment.Top)
                        .size(30.dp)
                        .padding(0.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = "4.7",
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(horizontal = 2.dp)
                )
                Spacer(modifier = Modifier.width(40.dp))
                Image(
                    painter = painterResource(id = R.drawable.truck__),
                    contentDescription = "Pizza",
                    modifier = Modifier
                        .size(35.dp)
                        .padding(0.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "Free",
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(horizontal = 2.dp)
                )

                Spacer(modifier = Modifier.width(40.dp))
                Image(
                    painter = painterResource(id = R.drawable.clock__),
                    contentDescription = "Pizza",
                    modifier = Modifier
                        .size(35.dp)
                        .padding(0.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "20 min",
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(horizontal = 2.dp)
                )
            }
            Spacer(modifier = Modifier.height(35.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 1.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "SIZE:",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(horizontal = 0.dp))
                TextButton(onClick = { onButtonClick(1); totalprice = unitPriceRegular },
                    colors = ButtonDefaults.textButtonColors(
                        getButtonColor(1)
                    ),
                    modifier = Modifier
                        .size(height = 50.dp, width = 100.dp),
                    shape = RoundedCornerShape(15.dp)
                ){
                    Text(text = "Regular", fontSize = 20.sp)
                }

                TextButton(onClick = { onButtonClick(2); totalprice = unitPriceLarge },
                    colors = ButtonDefaults.textButtonColors(
                        getButtonColor(2)
                    ),
                    modifier = Modifier
                        .size(height = 50.dp, width = 100.dp),
                    shape = RoundedCornerShape(15.dp)
                ){
                    Text(text = "Large", fontSize = 20.sp)
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            Text(text = "INGRIDENTS",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(horizontal = 15.dp))
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 0.dp)
                    .fillMaxWidth(),
                    //.align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Mustard_yellow_light)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.salt),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Mustard_yellow_light)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.potato_icon),
                        contentDescription = "",
                        modifier = Modifier
                            .size(40.dp)
                            .align(Alignment.Center)
                    )
                }
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Mustard_yellow_light)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.garlic),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Mustard_yellow_light)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.onion),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Mustard_yellow_light)
                        .align(Alignment.CenterVertically)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.chilli),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .background(colorResource(id = R.color.White_Blue))
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .padding(5.dp, 2.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Rs ${totalprice * count}", //to get total price
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 20.dp, horizontal = 10.dp),
                    fontSize = 25.sp
                )
                Row(modifier = Modifier
                    .width(120.dp)
                    .background(Mustard_yellow, shape = RoundedCornerShape(30.dp)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){
                    IconButton(onClick = {
                        if (count == 1) count = 1 else count--
                    }) { //to set default limit as 1
                        Icon(
                            Icons.Default.KeyboardArrowDown,
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                    Text(
                        text = "$count",
                        fontSize = 20.sp
                    )

                    IconButton(onClick = { count++ }) {
                        Icon(
                            Icons.Default.KeyboardArrowUp,
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }

                TextButton(
                    onClick = {
                        if(totalprice == unitPriceRegular)size = "Regular" else size = "Large"
                        addCart(Item_Name,totalprice ,count,size);
                            Toast.makeText(context , "Item added successfully" , Toast.LENGTH_SHORT).show()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Mustard_yellow),
                    modifier = Modifier
                        .padding(2.dp, 0.dp)
                        .height(54.dp),
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Icon(
                        Icons.Default.AddShoppingCart,
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }
                TextButton(
                    onClick = {
                        try {
                            navController.navigate("AddToCart")
                        } catch (e: Exception) {
                            Log.e("Navigation Error", e.toString())
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Mustard_yellow),
                    modifier = Modifier
                        .padding(2.dp, 0.dp)
                        .height(54.dp),
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Icon(
                        Icons.Default.ShoppingCart,
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }
    }
}

//@Composable
//fun ClassicFrenchFriesCart(Regular:Int,Large:Int) {
//    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
//    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)
//    var unitprice_Regular: Int by remember {
//        mutableStateOf<Int>(35)
//    }
//    var totalprice_Regular: Int by remember {
//        mutableStateOf<Int>(35)
//    }
//    var count_Regular by remember {
//        mutableStateOf<Int>(Regular)
//    }
//
//
//    fun updateRegularPrice() {
//        if(ClassicFrenchFries_Regular==0)
//        {
//            ClassicFrenchFries_RegularPrice=0
//        }
//        else {
//            totalprice_Regular = unitprice_Regular * count_Regular
//            ClassicFrenchFries_RegularPrice = totalprice_Regular
//        }
//        updatePrice()
//    }
//
//    var unitprice_Large: Int by remember {
//        mutableStateOf<Int>(55)
//    }
//    var totalprice_Large: Int by remember {
//        mutableStateOf<Int>(55)
//    }
//    var count_Large by remember {
//        mutableStateOf<Int>(Large)
//    }
//
//    fun updateLargePrice() {
//        if(ClassicFrenchFries_Large==0)
//        {
//            ClassicFrenchFries_LargePrice=0
//        }
//        else {
//            totalprice_Large = unitprice_Large * count_Large
//            ClassicFrenchFries_LargePrice = totalprice_Large
//        }
//        updatePrice()
//    }
//
//    var totalprice: Int by remember {
//        mutableStateOf<Int>(totalprice_Large+totalprice_Regular)
//    }
//    totalprice=totalprice_Large+totalprice_Regular
//    Column {
//        if (count_Regular > 0) {
//
//            Card(
//                shape = RoundedCornerShape(16.dp),
//                backgroundColor = Mustard_yellow,
//                modifier = Modifier
//                    .padding(10.dp)
//                    .fillMaxWidth()
//                    .wrapContentHeight(),
//            ) {
//                Box(
//                    modifier = Modifier
//                        .padding(16.dp)
//                        .fillMaxWidth()
//                        .wrapContentHeight()
//                        .background(color = Mustard_yellow_light)
//                ) {
//                    Row {
//                        Card(
//                            shape = RoundedCornerShape(15.dp),
//                            modifier = Modifier
//                                .padding(0.dp)
//                                .size(120.dp)
//                                .wrapContentHeight(),
//                        ) {
//
//                            Image(
//                                painter = painterResource(id = R.drawable.classic_french_fries),
//                                contentDescription = "classic_french_fries",
//                                modifier = Modifier
//                                    //.align(Alignment.Center)
//                                    .size(220.dp)
//                            )
//                        }
//                        Spacer(modifier = Modifier.width(10.dp))
//                        Column(
//                            modifier = Modifier
//                                .padding(horizontal = 5.dp)
//                                .fillMaxWidth()
//                        ) {
//                            Text(
//                                text = "Classic French Fries\n(Regular)",
//                                fontWeight = FontWeight.Bold,
//                                fontSize = 22.sp
//                            )
//
//                            Text(
//                                text = "PRICE : Rs $totalprice_Regular",
//                                fontWeight = FontWeight.Bold,
//                                modifier = Modifier.padding(
//                                    vertical = 10.dp,
//                                    horizontal = 2.dp
//                                ),
//                                fontSize = 15.sp
//                            )
//                            Box(
//                                modifier = Modifier
//                                    .size(height = 30.dp, width = 150.dp)
//                                    .background(color = Color.White, shape = CircleShape)
//
//                            ) {
//                                Row {
//                                    IconButton(onClick = {
//                                        if (count_Regular == 1) {
//                                            count_Regular = 0
//                                            ClassicFrenchFries_Regular=0
//                                        }
//                                        else count_Regular--;updateRegularPrice();updateLargePrice()
//                                    }) {
//                                        Icon(
//                                            Icons.Default.KeyboardArrowDown,
//                                            contentDescription = null,
//                                            modifier = Modifier.size(50.dp)
//                                        )
//                                    }
//                                    Spacer(modifier = Modifier.width(5.dp))
//                                    Text(
//                                        text = "$count_Regular", modifier = Modifier
//                                            .padding(vertical = 5.dp)
//                                            .padding(horizontal = 15.dp),
//                                        fontSize = 20.sp
//                                    )
//                                    Spacer(modifier = Modifier.width(1.dp))
//                                    IconButton(onClick = { count_Regular++;updateRegularPrice();updateLargePrice() }) {
//                                        Icon(
//                                            Icons.Default.KeyboardArrowUp,
//                                            contentDescription = null,
//                                            modifier = Modifier.size(50.dp)
//                                        )
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        if(count_Large>0)
//        {
//            Card(
//                shape = RoundedCornerShape(16.dp),
//                backgroundColor = Mustard_yellow,
//                modifier = Modifier
//                    .padding(10.dp)
//                    .fillMaxWidth()
//                    .wrapContentHeight(),
//            ) {
//                Box(
//                    modifier = Modifier
//                        .padding(16.dp)
//                        .fillMaxWidth()
//                        .wrapContentHeight()
//                        .background(color = Mustard_yellow_light)
//                ) {
//                    Row {
//                        Card(
//                            shape = RoundedCornerShape(15.dp),
//                            modifier = Modifier
//                                .padding(0.dp)
//                                .size(120.dp)
//                                .wrapContentHeight(),
//                        ) {
//                            Image(
//                                painter = painterResource(id = R.drawable.classic_french_fries),
//                                contentDescription = "classic_french_fries",
//                                modifier = Modifier
//                                    //.align(Alignment.Center)
//                                    .size(220.dp)
//                            )
//                        }
//                        Spacer(modifier = Modifier.width(10.dp))
//                        Column(
//                            modifier = Modifier
//                                .padding(horizontal = 5.dp)
//                                .fillMaxWidth()
//                        ) {
//                            Text(
//                                text = "Classic French Fries\n(Large)",
//                                fontWeight = FontWeight.Bold,
//                                fontSize = 22.sp
//                            )
//
//                            Text(
//                                text = "PRICE : Rs $totalprice_Large",
//                                fontWeight = FontWeight.Bold,
//                                modifier = Modifier.padding(
//                                    vertical = 10.dp,
//                                    horizontal = 2.dp
//                                ),
//                                fontSize = 15.sp
//                            )
//                            Box(
//                                modifier = Modifier
//                                    .size(height = 30.dp, width = 150.dp)
//                                    .background(color = Color.White, shape = CircleShape)
//
//                            ) {
//                                Row {
//                                    IconButton(onClick = {
//                                        if (count_Large == 1) {
//                                            count_Large = 0
//                                            ClassicFrenchFries_Large=0
//                                        }
//                                        else count_Large--;updateRegularPrice();updateLargePrice()
//                                    }) {
//                                        Icon(
//                                            Icons.Default.KeyboardArrowDown,
//                                            contentDescription = null,
//                                            modifier = Modifier.size(50.dp)
//                                        )
//                                    }
//                                    Spacer(modifier = Modifier.width(5.dp))
//                                    Text(
//                                        text = "$count_Large", modifier = Modifier
//                                            .padding(vertical = 5.dp)
//                                            .padding(horizontal = 15.dp),
//                                        fontSize = 20.sp
//                                    )
//                                    Spacer(modifier = Modifier.width(1.dp))
//                                    IconButton(onClick = { count_Large++ ;updateRegularPrice();updateLargePrice()}) {
//                                        Icon(
//                                            Icons.Default.KeyboardArrowUp,
//                                            contentDescription = null,
//                                            modifier = Modifier.size(50.dp)
//                                        )
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
//
//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//fun ClassicFrenchFriesWishlist(navController: NavController) {
//
//    val Mustard_yellow = colorResource(id = R.color.Mustard_yellow)
//    val Mustard_yellow_light = colorResource(id = R.color.Mustard_yellow_light)
//    Column {
//        Card(
//            shape = RoundedCornerShape(16.dp),
//            backgroundColor = Mustard_yellow,
//            modifier = Modifier
//                .padding(10.dp)
//                .fillMaxWidth()
//                .wrapContentHeight(),
//            onClick = { navController.navigate("ClassicFrenchFries") }
//        ) {
//            Box(
//                modifier = Modifier
//                    .padding(6.dp)
//                    .wrapContentHeight()
//                    .background(color = Mustard_yellow_light)
//                    .align(Alignment.CenterHorizontally)
//            ) {
//                Column(
//                    modifier = Modifier.fillMaxWidth(),
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Box(
//                        modifier = Modifier
//                            .padding(16.dp)
//                            .fillMaxWidth()
//                            .wrapContentHeight()
//                    ) {
//                        Image(
//                            painter = painterResource(id = R.drawable.classic_french_fries),
//                            contentDescription = "Pizza",
//                            modifier = Modifier
//                                .align(Alignment.Center)
//                                .size(200.dp)
//                        )
//                        Icon(
//                            imageVector = Icons.Default.Delete,
//                            contentDescription = "Remove from favorites",
//                            tint = Color.White,
//                            modifier = Modifier
//                                .align(Alignment.TopEnd)
//                                .size(40.dp)
//                                .background(Color.Gray, shape = CircleShape)
//                                .padding(5.dp)
//                                .clickable(onClick = {
//                                    ClassicFrenchFries_Wishlist = 0
//                                })
//                        )
//                    }
//                    Spacer(modifier = Modifier.height(10.dp))
//                    Row (modifier = Modifier.fillMaxWidth(),
//                        verticalAlignment = Alignment.CenterVertically,
//                        horizontalArrangement = Arrangement.Center) {
//                        Column {
//                            Text(
//                                text = "Classic French Fries",
//                                fontWeight = FontWeight.Bold,
//                                fontSize = 30.sp,
//                                color = Color.Black
//                            )
//                            Spacer(modifier = Modifier.height(6.dp))
//                            Text(
//                                text = "( Size : Regular , Large )",
//                                fontWeight = FontWeight.Bold,
//                                fontSize = 15.sp,
//                                color = Color.White,
//                                modifier = Modifier.align(Alignment.CenterHorizontally)
//                            )
//                            Spacer(modifier = Modifier.height(10.dp))
//                        }
//                    }
//                }
//            }
//        }
//    }
//}

