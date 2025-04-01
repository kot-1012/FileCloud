const stringToHashNumber = (string: string) => {
    let hash = 0, i, chr;
    if (string.length === 0) return hash;
    for (i = 0; i < string.length; i++) {
        chr = string.charCodeAt(i);
        hash = ((hash << 5) - hash) + chr;
        hash |= 0; // Convert to 32bit integer
    }
    return hash;
};

const stringToHashColor = (string: string) => {
    const colors = [
        '#98d6c0',
        '#518ee8',
        '#d9437a',
        '##7e3ce8'
    ];

    return colors[stringToHashNumber(string) % colors.length];
}

export {
    stringToHashNumber,
    stringToHashColor
};
