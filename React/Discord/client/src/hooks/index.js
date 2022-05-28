import { useLayoutEffect, useState } from "react";

import { useSelector } from "react-redux";

// Detect window width
export const useWindowWidth = () => {
  const [width, setWidth] = useState(0);

  useLayoutEffect(() => {
    function updateSize() {
      setWidth(window.innerWidth);
    }
    window.addEventListener("resize", updateSize);
    updateSize();
    return () => window.removeEventListener("resize", updateSize);
  }, []);
  return width;
};

export const useActiveChannel = () => {
  const loading = useSelector((state) => state.channels.loading);
  const activeChannelId = useSelector((state) => state.channels.active);
  const channelsById = useSelector((state) => state.channels.byId);
  return !loading && channelsById[activeChannelId];
};

export const usePopover = () => {
  const [showPopover, setShowPopover] = useState(false);
  const [user, setUser] = useState("");
  const [anchorEl, setAnchorEl] = useState(null);

  const handleClick = (event, user) => {
    setUser(user);
    setShowPopover(true);
    setAnchorEl(event.currentTarget);
  };

  const handleClickAway = () => {
    setUser("");
    setShowPopover(false);
    setAnchorEl(null);
  };

  return [
    user,
    anchorEl,
    showPopover,
    setShowPopover,
    handleClick,
    handleClickAway,
  ];
};
