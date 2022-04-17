export const makeShortText = (text) => {
    if(text.length > 50) {
        return text.substring(0, 50) + '...';
    }
    return text;
}