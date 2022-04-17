import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import {
  makeStyles,
  InputBase,
  List,
  ListItemAvatar,
  ListItem,
  ListItemText,
  Box,
  Typography,
} from "@material-ui/core";
import SearchIcon from "@material-ui/icons/Search";

import { getProducts } from "../../actions/productActions";
import { makeShortText } from "../../utils/makeShortText";

const useStyles = makeStyles((theme) => ({
  search: {
    position: "absolute",
    borderRadius: theme.shape.borderRadius,
    backgroundColor: "#fff",
    marginLeft: theme.spacing(3),
    top: 12,
    width: "30vw",
    [theme.breakpoints.down("md")]: {
      width: "45vw",
      marginLeft: "10%",
      top: 10,
    },
  },
  searchIcon: {
    padding: theme.spacing(1),
    height: "100%",
    pointerEvents: "none",
    alignItems: "center",
    justifyContent: "center",
    color: "#2874f0",
  },
  inputRoot: {
    fontSize: 16,
    [theme.breakpoints.down("md")]: {
      width: "45vw",
    },
    width: "30vw",
  },
  inputInput: {
    width: "100%",
    padding: theme.spacing(1),
    paddingLeft: `calc(0.1em + ${theme.spacing(2)}px)`,
  },
  listComponent: {
    width: "30vw",
    height: 300,
    overflowY: "auto",
    background: "#ffff",
    color: "#000",
    [theme.breakpoints.down("md")]: {
      width: "45vw",
    },
  },
  listItem: {
    "&:hover": {
      cursor: "pointer",
      backgroundColor: "#F0F6FF",
    },
    color: "#000",
  },
  listText: {
    margin: "0px 10px",
    color: "#000",
    [theme.breakpoints.down("md")]: {
     fontSize:14,
    },
  },
  productAvatar: {
    width: 75,
    height: 75,
    objectFit: "contain",
    [theme.breakpoints.down("md")]: {
      width: 50,
      height: 50,
    },
  },
}));
function SearchBar() {
  const classes = useStyles();
  const dispatch = useDispatch();
  const { products } = useSelector((state) => state.productReducer);
  const [searchText, setSearchText] = useState("");
  const [isOpen, setIsOpen] = useState(true);

  useEffect(() => {
    dispatch(getProducts());
  }, [dispatch]);

  const handleSearchInput = (e) => {
    setSearchText(e.target.value);
    setIsOpen(true);
  };

  const closeSearchBox = () => {
    setTimeout(() => {
      setIsOpen(false);
    }, 200);
  };

  return (
    <div className="searchbar" style={{ width: "43%" }}>
      <div className={classes.search} onBlur={closeSearchBox}>
        <div style={{ display: "flex" }}>
          <InputBase
            placeholder="Search for products, brands and more"
            classes={{
              root: classes.inputRoot,
              input: classes.inputInput,
            }}
            inputProps={{ "aria-label": "search" }}
            value={searchText}
            onChange={handleSearchInput}
          />
          <div className={classes.searchIcon}>
            <SearchIcon />
          </div>
        </div>
        {searchText && isOpen && (
          <Box boxShadow={4} className={classes.listComponent}>
            <List>
              {products
                ?.filter((product) =>
                  product.title.longTitle
                    .toLowerCase()
                    .includes(searchText.toLowerCase())
                )
                ?.map((product) => (
                  <a href={`/product/${product._id}`}>
                    <ListItem className={classes.listItem}>
                      <ListItemAvatar className={classes.listAvatar}>
                        <img
                          className={classes.productAvatar}
                          src={product.url}
                        />
                      </ListItemAvatar>
                      <ListItemText>
                        <Typography className={classes.listText}>
                          {makeShortText(product.title.longTitle)}
                        </Typography>
                      </ListItemText>
                    </ListItem>
                  </a>
                ))}
            </List>
          </Box>
        )}
      </div>
    </div>
  );
}

export default SearchBar;
